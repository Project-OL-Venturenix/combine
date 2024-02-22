const path = require('path');
const FileApi = require('../api/FileApi');
const JavaRunner = require('./JavaRunner');
const { response } = require('express');
const axios = require('axios');

function Factory() {
  this.createRunner = function createRunner(lang) {
    let runner;

    if (lang === 'java') {
      runner = new JavaRunner();
    }

    return runner;
  };
}

module.exports = {
  run(lang, code, res) {
    const factory = new Factory();
    const runner = factory.createRunner(lang.toLowerCase());

    const directory = path.join(__dirname, 'temp');
    const sourceFile = path.join(directory, runner.defaultFile());
    console.log(`sourceFile: ${sourceFile}`);
    console.log(`testFile: ${testFile}`);
    const filename = path.parse(sourceFile).name; // main
    const extension = path.parse(sourceFile).ext; // .java
    console.log(`filename: ${filename}`);
    console.log(`extension: ${extension}`);

    // Add package declaration to the code
    // const packageDeclaration = 'package com.vtxlab.projectol.server_test_cases.temp;';
    // const codeWithPackage = `${packageDeclaration}\n${code}`;
    // console.log('codeWithPackage: ', codeWithPackage);
    // FileApi.saveFileWithPackage(sourceFile, codeWithPackage, () => {
    //   runner.run(sourceFile, directory, filename, extension, (status, message) => {
    //     const result = {
    //       status,
    //       message,
    //     };
    //     res.end(JSON.stringify(result));
    //   });
    // });

    FileApi.saveFile(sourceFile, code, () => {  // Save the code to a file
      console.log('Runner saveFile : ' );
      runner.run(sourceFile, directory, filename, extension, (status, message) => {  // Run the code
        const result = {
          status,
          message,
        };
        res.end(JSON.stringify(result));  // Send the result as a JSON string
      });
    });

    // Create JSON data (assuming you want to store the entire code)
    // const jsonSourceFile = {
    //   filename,
    //   extension,
    //   code: codeWithPackage, // Include the Java code itself
    // };
   // console.log('jsonSourceFile: ', jsonSourceFile);
    // Save sourceFile as JSON

    // FileApi.saveFileToJSON(sourceFile + '.json', jsonSourceFile, () => {
    //   runner.run(sourceFile, directory, filename, extension, (status, message) => {
    //     const result = {
    //       status,
    //       message,
    //     };
    //     res.end(JSON.stringify(result));

    //     axios.post('http://localhost:8085/api/test/receive', result)
    //       .then(response => {
    //         console.log(response.data);
    //       })
    //       .catch(error => {
    //         console.error('Error sending request : ', error);
    //       });

    //   });
    // });

    // FileApi.saveFileToJSON(sourceFile + '.json', jsonSourceFile, () => {
    //   runner.run(sourceFile, directory, filename, extension, (status, message) => {
    //     const result = {
    //       filename, // Include filename in the result object
    //       extension, // Include extension in the result object
    //       code // Include code in the result object
    //     };
    //     res.end(JSON.stringify(result));

    //     fetch('http://localhost:8085/api/test/receive', {
    //       method: 'POST',
    //       headers: {
    //         'Content-Type': 'application/json', // Set content type for JSON
    //       },
    //       body: JSON.stringify(result), // Serialize result object as JSON
    //     })
    //       .then(response => {
    //         if (!response.ok) {
    //           throw new Error('Network response was not ok');
    //         }
    //         return response.text(); // Parse response as text
    //       })
    //       .then(responseData => {
    //         console.log('Response from Spring Boot:', responseData);
    //       })
    //       .catch(error => {
    //         console.error('Error sending request:', error);
    //       });
    //   });
    // });
  },
};