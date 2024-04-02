import mkdirp from 'mkdirp';
import path from 'path';
import fs from 'fs';

module.exports = {
  saveFile(file, data, callback, questionId) {
    mkdirp(path.dirname(file), (err) => {
      if (err) return callback(err);

      const jsonData = data;
      console.log('generate file data' + data);
      const jsonDataWithoutClosingBrace = jsonData.replace(/\}\s*$/, '');
      //add mainmethod
      const jsonFile = path.join(__dirname, `../templates/Question${questionId}`, `Question${questionId}.json`);
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
        const { mainMethod } = mainMethodData;
        if (typeof mainMethod !== 'string') {
          throw new Error('Invalid JSON data format: Missing or invalid string properties');
        }

        const javaClass = `${jsonDataWithoutClosingBrace}\n\n${mainMethod}\n\n`;

        fs.writeFile(file, javaClass, 'utf8', (err2) => {
          if (err2) throw err2;
          callback();
        });
      });
    });
  },
  
    startConvertJsonToJava(questionId , callback) {
    const jsonFile = path.join(__dirname, `../templates/Question${questionId}`, `Question${questionId}.json`);
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
      const { classDeclaration, code } = jsonData;
      if (typeof classDeclaration !== 'string' || typeof code !== 'string') {
        throw new Error('Invalid JSON data format: Missing or invalid string properties');
      }
      const javaCode = `${classDeclaration}\n${code}\n`;
      callback(javaCode);
    });
  },

  getFile(lang, callback, questionId) {
    let file = '';
    const language = lang.toLowerCase();
    if (language === 'java') {
      file = path.join(__dirname, `../templates/Question${questionId}`, `Question${questionId}.json`);
      if (!fs.existsSync(file)) {
        fs.writeFileSync(file, '');
      }
      this.startConvertJsonToJava((javaCode) => {
        fs.writeFile(file, javaCode, (err) => {
          if (err) throw err;
          console.log(`Question${questionId}.java file created with Java code.`);
          fs.readFile(file, (err, data) => {
            if (err) throw err;
            console.log(data.toString());
            callback(data.toString());
          });
        });
      }, questionId);
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
