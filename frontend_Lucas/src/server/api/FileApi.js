const fs = require('fs');
const path = require('path');
const mkdirp = require('mkdirp');

module.exports = {
  saveFile(file, data, callback) {
    mkdirp(path.dirname(file), (err) => {
      if (err) return callback(err);

      const jsonData = data;
      const jsonDataWithoutClosingBrace = jsonData.replace(/\}\s*$/, '');

      const jsonFile = path.join(__dirname, '../templates', 'Question1.json');
      fs.readFile(jsonFile, 'utf8', (err, data) => {
        if (err) throw err;
        let mainMethodData;
        try {
          mainMethodData = JSON.parse(data);
        } catch (parseError) {
          throw new Error('Error parsing JSON data');
        }
        if (!mainMethodData || typeof mainMethodData !== 'object') {
          throw new Error('Invalid JSON data format: Not an object');
        }
        const { mainMethod ,endOfCode} = mainMethodData;
        if (typeof mainMethod !== 'string'|| typeof endOfCode !== 'string') {
          throw new Error('Invalid JSON data format: Missing or invalid string properties');
        }

        const javaClass = `${jsonDataWithoutClosingBrace}\n\n${mainMethod}\n\n${endOfCode}`;

        fs.writeFile(file, javaClass, 'utf8', (err2) => {
          if (err2) throw err2;
          callback();
        });
      });
    });
  },

  startConvertJsonToJava(callback) {
    const jsonFile = path.join(__dirname, '../templates', 'Question1.json');
    fs.readFile(jsonFile, 'utf8', (err, data) => {
      if (err) throw err;
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
      file = path.join(__dirname, '../templates', 'Question3.java');
      if (!fs.existsSync(file)) {
        fs.writeFileSync(file, '');
      }
      this.startConvertJsonToJava((javaCode) => {
        fs.writeFile(file, javaCode, (err) => {
          if (err) throw err;
          console.log('Question3.java file created with Java code.');
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
};