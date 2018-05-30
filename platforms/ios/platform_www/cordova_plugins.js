cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
  {
    "id": "cordova-hot-code-push-plugin.chcp",
    "file": "plugins/cordova-hot-code-push-plugin/www/chcp.js",
    "pluginId": "cordova-hot-code-push-plugin",
    "clobbers": [
      "chcp"
    ]
  },
  {
    "id": "cordova-plugin-wechat.Wechat",
    "file": "plugins/cordova-plugin-wechat/www/wechat.js",
    "pluginId": "cordova-plugin-wechat",
    "clobbers": [
      "Wechat"
    ]
  }
];
module.exports.metadata = 
// TOP OF METADATA
{
  "cordova-hot-code-push-plugin": "1.5.3",
  "cordova-plugin-jikaicai": "0.0.1",
  "cordova-plugin-wechat": "2.3.0",
  "cordova-plugin-whitelist": "1.3.3"
};
// BOTTOM OF METADATA
});