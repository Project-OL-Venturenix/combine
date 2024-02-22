const fs = require('fs');
const path = require('path');
const mkdirp = require('mkdirp');

module.exports = {
   startConvertJsonToJava(callback) {
    const jsonFile = path.join(__dirname, '../templates', 'Question1.json');
    fs.readFile(jsonFile, 'utf8', (err, data) => {
      if (err) {
        throw err;
      }
      let jsonData;
      try {
        jsonData = JSON.parse(data);
      } catch (parseError) {
        throw new Error('Error parsing JSON data');
      }
      if (!jsonData || typeof jsonData !== 'object') {
        throw new Error('Invalid JSON data format: Not an object');
      }
      const { classDeclaration, code, endOfCode } = jsonData;
      if (typeof classDeclaration !== 'string' || typeof code !== 'string' || typeof endOfCode !== 'string') {
        throw new Error('Invalid JSON data format: Missing or invalid string properties');
      }
      const javaCode = `${classDeclaration}\n${code}\n${endOfCode}`;
      callback(javaCode);
    });
  },

  getFile(lang, callback) {
    let file = '';
    const language = lang.toLowerCase();
    if (language === 'java') {
      file = path.join(__dirname, '../templates', 'Question1.java');
      // Create the file if it doesn't exist
      if (!fs.existsSync(file)) {
        fs.writeFileSync(file, ''); // Create an empty file
      }
      // Convert JSON to Java code and write to Question1.java
      this.startConvertJsonToJava((javaCode) => {
        fs.writeFile(file, javaCode, (err) => {
          if (err) throw err;
          console.log('Question1.java file created with Java code.');
          fs.readFile(file, (err, data) => {
            if (err) throw err;
            console.log(data.toString());
            callback(data.toString());
          });
        });
      });
    } else if (language === 'c') {
      file = path.join(__dirname, '../templates', 'Hello.c');
    } else if (language === 'c++') {
      file = path.join(__dirname, '../templates', 'Hello.cpp');
    } else if (language === 'javascript') {
      file = path.join(__dirname, '../templates', 'Hello.js');
    } else if (language === 'python') {
      file = path.join(__dirname, '../templates', 'Hello.py');
    } else {
      callback('');
      return;
    }
  },
  readJSONFile: function (filePath, callback) {
    fs.readFile(filePath, 'utf8', (err, data) => {
      if (err) {
        throw err;
      }
      let jsonData;
      try {
        jsonData = JSON.parse(data);
      } catch (parseError) {
        throw new Error('Error parsing JSON data');
      }
      callback(jsonData);
    });
  },
  writeJSONFile: function (filePath, data, callback) {
    // Convert data to JSON string
    const jsonData = JSON.stringify(data, null, 2); // Add indentation for readability

    // Create parent directories if they don't exist
    mkdirp(path.dirname(filePath), (err) => {
      if (err) throw err;

      // Write the JSON string to the file
      fs.writeFile(filePath, jsonData, 'utf8', (err2) => {
        if (err2) throw err2;
        callback();
      });
    });
  },

  writeJavaFile: function (filePath, javaCode, callback) {
    // Create parent directories if they don't exist
    mkdirp(path.dirname(filePath), (err) => {
      if (err) throw err;

      // Write the Java code to the file
      fs.writeFile(filePath, javaCode, 'utf8', (err2) => {
        if (err2) throw err2;
        callback();
      });
    });
  }
};
