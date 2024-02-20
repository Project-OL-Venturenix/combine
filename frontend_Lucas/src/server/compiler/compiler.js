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

  saveFile(file, code, callback) {
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