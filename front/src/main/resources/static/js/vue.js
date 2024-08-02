const cocktailListInit = ["ホワイトレディ", "ブルーハワイ", "ニューヨーク"];
const const_params = {
  search: false,
  page: 0,
};
const const_dialog_params = {
};
//Mount App.vue
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
      openDialog(processId, id) {
        this.proccessId = processId;
        consoleLog("openDialog processId:", processId);
        consoleLog("openDialog id:", id);
        if ('edit' === processId || 'delete' === processId) {
          this.params = Object.assign({}, const_params);
          if (id != '') {
            this.params['accountId'] = id;
          }
          axios.get("http://localhost:8080/account/rest?" + this.createParams())
            // thenで成功した場合の処理
            .then((response) => {
              consoleLog("ステータスコード:", response.data);
              consoleLog("ステータスコード:", response.data.response.list[0]);
              var values = response.data.response.list[0];
              // dialogText への設定
              document.querySelectorAll('.dialogText').forEach((element, index) => {
                document.querySelector("#" + element.id).parentNode.MaterialTextfield.change(values[element.id.replace('dialog_', '')]);
              });

            })
            // catchでエラー時の挙動を定義
            .catch(err => {
              consoleLog("err:", err);
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
      next: function() {
      },
      back: function() {
      },
      /** レスト処理(GET) */
      get: function() {
        consoleLog("ステータスコード:", this.params);
        this.params = Object.assign({}, const_params);
        // dialogText への設定
        document.querySelectorAll('.searchText').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id] = element.value;
          }
        });
        consoleLog("ステータスコード:", this.params);
        axios.get("http://localhost:8080/account/rest?" + this.createParams())
          // thenで成功した場合の処理
          .then((response) => {
            consoleLog("ステータスコード:", response.data);
            this.items = response.data.response.list;
          })
          // catchでエラー時の挙動を定義
          .catch(err => {
            consoleLog("err:", err);
          });
      },
      /** Dialog操作 */
      dialogProccess: function() {
        // 新規登録
        if (this.proccessId == 'new') {
          this.post();
        }
        // 編集
        if (this.proccessId == 'edit') {
          this.put();
        }
        // 削除
        if (this.proccessId == 'delete') {
          this.delete();
        }
      },
      /** レスト処理(post) */
      post: function() {
        consoleLog("ステータスコード:", this.params);
        this.params = Object.assign({}, const_dialog_params);
        // dialogText クラスの初期化
        document.querySelectorAll('.dialogText').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('dialog_', '')] = element.value;
          }
        });
        this.params['active'] = dialog_active.value;
        consoleLog("ステータスコード:", this.params);
        axios.post("http://localhost:8080/account/rest", this.createParams())
          // thenで成功した場合の処理
          .then((response) => {
            consoleLog("ステータスコード:", response.data);
          })
          // catchでエラー時の挙動を定義
          .catch(err => {
            consoleLog("err:", err);
          });
      },
      /** レスト処理(PUT) */
      put: function() {
        consoleLog("ステータスコード:", this.params);
        this.params = Object.assign({}, const_dialog_params);
        // dialogText クラスの初期化
        document.querySelectorAll('.dialogText').forEach((element, index) => {
          if (element.value != '') {
            this.params[element.id.replace('dialog_', '')] = element.value;
          }
        });
        this.params['active'] = dialog_active.value;
        consoleLog("ステータスコード:", this.params);
        axios.put("http://localhost:8080/account/rest", this.createParams())
          // thenで成功した場合の処理
          .then((response) => {
            consoleLog("ステータスコード:", response.data);
          })
          // catchでエラー時の挙動を定義
          .catch(err => {
            consoleLog("err:", err);
          });
      },
      /** レスト処理(PUT) */
      exceptionHandler: function(error) {
        consoleLog("ステータスコード:", this.params);
      }
    }
  }).mount('#app');
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

function consoleLog(key, value) {
  if (true) {
    console.log(key, value);
  }
}


