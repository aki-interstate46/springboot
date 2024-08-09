/*
 * vue.js内で利用するconst情報 
 * vue.js以外で利用する場合はconst.jsに記載してください
 */

/** 検索処理時のデフォルトパラメータ */
const const_params = {
  search: false,
  page: 0,
};

/** Dialog送信時のデフォルトパラメータ */
const const_dialog_params = {
};

/** 多言語対応 */
const i18n = VueI18n.createI18n({
  locale: LANG_JA,
  messages
});

/** Vueのオプション */
const options = {
  //<i18n>タグの読み込み
  //customBlockHandler(block, filename, options) {
  //  if (block.type !== 'i18n') {
  //    return;
  // }
  //  // メッセージの登録
  //  const messages = JSON.parse(block.content);
  //  for (let locale in messages) {
  //   i18n.global.mergeLocaleMessage(locale, messages[locale]);
  //  }
  //}
}

/*
 *vue mount処理
 */
window.addEventListener("load", function() {
  Vue.createApp({
    data() {
      return {
        items: []
        , params: {}
        , open: false
        , modal: {}
        , activeList: [
          { id: "active", name: "active" },
          { id: "inactive", name: "inactive" }
        ]
        , showModal: true
        , proccessId: ''
      }
    },
    methods: {
      /* UIの言語を切り替える */
      changeLanguage: function(lang) {
        // 言語が未入力、または対象外の言語の場合、日本語を設定する
        if (!lang || (LANG_JA !== lang && LANG_EN !== lang)) {
          lang = LANG_JA;
        }
        this.$i18n.locale = lang;
      },
      createParams: function(processId) {
        var _params = "";
        for (var key in this.params) {
          var val = this.params[key];
          var append = (_params === "" ? "" : "&");
          _params = _params + append + key + "=" + val;
        }
        consoleLog("_params:" + _params)
        return _params;
      },
      openDialog: async function(processId, id) {
        this.proccessId = processId;
        consoleLog("openDialog processId:", processId);
        consoleLog("openDialog id:", id);
        if ('edit' === processId || 'delete' === processId) {
          this.params = Object.assign({}, const_params);
          if (isNotEmpty(id)) {
            this.params['accountId'] = id;
          }
          await axios.get("http://localhost:8080/account/rest?" + this.createParams())
            // thenで成功した場合の処理
            .then((response) => {
              consoleLog("ステータスコード:", response.data);
              consoleLog("ステータスコード:", response.data.response.list[0]);
              var values = response.data.response.list[0];
              // dialogText への設定
              document.querySelectorAll('.dialogText').forEach((element, index) => {
                document.querySelector("#" + element.id).parentNode.MaterialTextfield.change(values[element.id.replace('dialog_', '')]);
              });
              // dialogText への設定
              document.querySelectorAll('.dialogSelect').forEach((element, index) => {
                document.querySelector("#" + element.id).parentNode.MaterialTextfield.change(values[element.id.replace('dialog_', '')]);
              });
            })
            // catchでエラー時の挙動を定義
            .catch(err => {
              exceptionHandler(err);
            });
        } else {
          // dialogText クラスの初期化
          document.querySelectorAll('.dialogText').forEach((element, index) => {
            element.parentNode.MaterialTextfield.change('');
          });
        }
        var dialog = document.querySelector('dialog');
        dialog.showModal();
      },
      closeDialog(processId) {
        var dialog = document.querySelector('dialog');
        dialog.close();
        this.get();
      },
      next: async function() {
      },
      back: async function() {
      },
      /** レスト処理(GET) */
      get: async function() {
        consoleLog("ステータスコード:", this.params);
        this.params = Object.assign({}, const_params);
        // dialogText への設定
        document.querySelectorAll('.searchText').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('search_', '')] = element.value;
          }
        });
        // dialogText への設定
        document.querySelectorAll('.searchSelect').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('search_', '')] = element.value;
          }
        });
        consoleLog("ステータスコード:", this.params);
        await axios.get("http://localhost:8080/account/rest?" + this.createParams())
          // thenで成功した場合の処理
          .then((response) => {
            consoleLog("ステータスコード:", response.data);
            this.items = response.data.response.list;
          })
          // catchでエラー時の挙動を定義
          .catch(err => {
            exceptionHandler(err);
          });
      },
      /** Dialog操作 */
      dialogProccess: async function() {
        // 新規登録
        if (this.proccessId == 'new') {
          if (await this.post()) {
            this.closeDialog(this.proccessId);
          }
        }
        // 編集
        if (this.proccessId == 'edit') {
          if (awaitthis.put()) {
            this.closeDialog(this.proccessId);
          }
        }
        // 削除
        //        if (this.proccessId == 'delete') {
        //          this.delete();
        //        }
      },
      /** レスト処理(post) */
      post: async function() {
        consoleLog("ステータスコード:", this.params);
        this.params = Object.assign({}, const_dialog_params);
        // dialogText クラスの初期化
        document.querySelectorAll('.dialogText').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('dialog_', '')] = element.value;
          }
        });
        // dialogSelet クラスの初期化
        document.querySelectorAll('.dialogSelect').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('dialog_', '')] = element.value;
          }
        });
        consoleLog("ステータスコード:", this.params);
        await axios.post("http://localhost:8080/account/rest", this.createParams())
          // thenで成功した場合の処理
          .then((response) => {
            consoleLog("post:", response.data);
            consoleLog("ステータスコード:", response.data.inputError);
            if (response.data.globalError !== '') {
              values = response.data.inputError;
              for (var item in values) {
                $('#dialog_div_' + item).addClass('is-invalid');
                $('#dialog_div_' + item).addClass('is-focused');
                $('#dialog_error_' + item).text(messages[this.$i18n.locale][values[item]]);
              }
              alert(response.data.globalError);
              return false;
            }
            return true;
          })
          .catch(err => {
            exceptionHandler(err);
          });
      },
      /** レスト処理(PUT) */
      put: async function() {
        consoleLog("ステータスコード:", this.params);
        this.params = Object.assign({}, const_dialog_params);
        // dialogText クラスの初期化
        document.querySelectorAll('.dialogText').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('dialog_', '')] = element.value;
          }
        });
        // dialogText クラスの初期化
        document.querySelectorAll('.dialogSelect').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('dialog_', '')] = element.value;
          }
        });
        consoleLog("ステータスコード:", this.params);
        await axios.put("http://localhost:8080/account/rest", this.createParams())
          // thenで成功した場合の処理
          .then((response) => {
            consoleLog("ステータスコード:", response.data);
            if (response.data.globalError !== '') {
              values = response.data.inputError;
              for (var item in values) {
                $('#dialog_div_' + item).addClass('is-invalid');
                $('#dialog_div_' + item).addClass('is-focused');
                $('#dialog_error_' + item).text(values[item]);
              }
              alert(response.data.globalError);
              return false;
            }
            return true;
          })
          // catchでエラー時の挙動を定義
          .catch(err => {
            exceptionHandler(err);
          });
      },
      /** レスト処理(PUT) */
      exceptionHandler: function(error) {
        consoleLog("ステータスコード:", this.params);
      },
      /** focusIn */
      focusIn: function(element) {
        this.focusProcess('focusIn', element);
      },
      /** focusIn */
      focusOut: function(element) {
        this.focusProcess('focusOut', element);
      },
      /** focus */
      focusProcess: function(focusKey, element) {
        consoleLog(focusKey + ":", element);
        const target = element.target;
        const targetId = target.id;
        const defaultId = targetId.replace('dialog_', '');
        const elm = document.getElementById(targetId);
        // required check
        if (elm.required && isEmpty(elm.value)) {
          $('#dialog_div_' + defaultId).addClass('is-invalid');
          $('#dialog_div_' + defaultId).addClass('is-focused');
          $('#dialog_error_' + defaultId).text(messages[this.$i18n.locale][values[item]]);
          return;
        }
      },
    }
  }, options)
    .use(i18n)
    .mount('#app');
}, false);

/*
 * 画面をロックする
 */
function lockScreen() {
  var dfd = $.Deferred();
  document.body.style.cursor = "wait";
  dfd.resolve();
  return dfd.promise();
}

/*
 * 画面のロックを解除する
 */
function unlockScreen() {
  var dfd = $.Deferred();
  document.body.style.cursor = "auto";
  dfd.resolve();
  return dfd.promise();
}

/*
* 未入力の確認を行う
* key:固定文言
* value:表示内容尾
 */
function consoleLog(key, value) {
  if (true) {
    if (isEmpty(value)) {
      console.log(key);
    } else {
      console.log(key, value);
    }
  }
}

/*
* 値が存在しない場合、true
 * value:値
 */
function isEmpty(value) {
  if (value == undefined || value == null || value == '') {
    return true;
  }
  return false;
}

/*
 * 値が存在している場合、true
 * value:値
 */
function isNotEmpty(value) {
  return !isEmpty(value);
}


