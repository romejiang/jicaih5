#!/usr/bin/env node
module.exports = function(context) {
  var fs = context.requireCordovaModule('fs'),
    path = context.requireCordovaModule('path');
  var platformRoot = path.join(context.opts.projectRoot, 'platforms/android/app/src/main');
  var manifestFile = path.join(platformRoot, 'AndroidManifest.xml');

  if (fs.existsSync(manifestFile)) {
  
    fs.readFile(manifestFile, 'utf8', function (err,data) {
  
      if (err) {
        throw new Error('Unable to find AndroidManifest.xml: ' + err);
      }
  
      var appClass = 'JiKaiH5Activity';
  
      if (data.indexOf(appClass) == -1) {
        var result = data.replace(/MainActivity/g,  appClass);
        fs.writeFile(manifestFile, result, 'utf8', function (err) {
          if (err) throw new Error('Unable to write into AndroidManifest.xml: ' + err);
        })
      }
    });
  } else {
    throw new Error('Unable to find AndroidManifest.xml: ' + err);
}
};