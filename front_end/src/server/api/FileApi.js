const mkdirp = require('mkdirp');
const fs = require('fs');
const getDirName = require('path').dirname;
const path = require('path');
const { spawn } = require('child_process');

module.exports = {
  getFile(lang, callback) {
    let questionFile = '';
    let testFile = '';
    const language = lang.toLowerCase();
    if (language === 'java') {
      questionFile = path.join(__dirname, '../templates', 'Question1.java');
      testFile = path.join(__dirname, '../templates', 'Question1Test.java');
    } else {
      callback('');
      return;
    }
    fs.readFile(questionFile, (err, data) => {
      if (err) {
        throw err;
      }
      console.log(data.toString());
      callback(data.toString());
    });
  },
  saveFile(file, callback) {
    // create parent directories if they doesn't exist.
    mkdirp(getDirName(file), (err) => {
      if (err) return callback(err);

      return fs.writeFile(file, (err2) => {
        if (err2) {
          throw err2;
        }
        callback;
      });
    });
  },


  saveFileWithPackage(file, code, callback) {
    // create parent directories if they doesn't exist.
    mkdirp(getDirName(file), (err) => {
      if (err) return callback(err);

      return fs.writeFile(file, code, (err2) => {
        if (err2) {
          throw err2;
        }
        callback;
      });
    });
  },

  saveFileToJSON(file, code, callback) {
    // Ensure data is an object before serialization
    if (typeof code !== 'object') {
      throw new Error('Data must be an object to save as JSON');
    }

    // Convert data to JSON string
    const jsonData = JSON.stringify(code, null, 2); // Add indentation for readability

    // Create parent directories if they don't exist
    mkdirp(getDirName(file), (err) => {
      if (err) return callback(err);

      // Write the JSON string to the file
      fs.writeFile(file, jsonData, 'utf8', (err2) => {
        if (err2) {
          throw err2;
        }
        callback(); // Indicate successful save
      });
    });
  }
};
// runMavenTests(directory, callback) {
//   const springBootProjectDirectory = '/code-editor-react';
//   console.log('springBootProjectDirectory : ' + springBootProjectDirectory);

//   const mvnProcess = spawn('mvn', ['clean', 'test'], {
//     cwd: springBootProjectDirectory,
//   });

//   mvnProcess.stdout.on('data', (data) => {
//     console.log(`mvn stdout: ${data}`);
//   });

//   mvnProcess.stderr.on('data', (data) => {
//     console.error(`mvn stderr: ${data}`);
//   });

//   mvnProcess.on('close', (code) => {
//     console.log(`mvn process exited with code ${code}`);
//     // You can handle the callback based on the exit code of mvn process
//     if (code === 0) {
//       callback(null, 'Tests executed successfully.');
//     } else {
//       callback(new Error(`mvn process exited with code ${code}`));
//     }
//   });
// },
//};