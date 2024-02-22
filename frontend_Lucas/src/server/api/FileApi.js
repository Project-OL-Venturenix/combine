const mkdirp = require('mkdirp');
const fs = require('fs');
const getDirName = require('path').dirname;
const path = require('path');

module.exports = {
  convertJsonToJava(callback) {
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
      this.convertJsonToJava((javaCode) => {
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

  saveFile(file, code, callback) {
    // create parent directories if they doesn't exist.
    mkdirp(getDirName(file), (err) => {
      if (err) return callback(err);

      return fs.writeFile(file, code, (err2) => {
        if (err2) {
          throw err2;
        }

        callback();
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
