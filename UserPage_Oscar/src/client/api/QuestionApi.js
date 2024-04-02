import axios from 'axios';
import { startConvertJsonToJava } from "../../server/api/FileApi";
import { BASE_URL } from './config';

export const getQuestions = async (accessToken) => {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/questions`,
            { headers: { Authorization: `Bearer ${accessToken}` } }
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
}

export const getQuestionsList = async (accessToken, eventId) => {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/questions/event/${eventId}`,
            { headers: { Authorization: `Bearer ${accessToken}` } }
        );
        const questions = response.data;
        questions.forEach(async (question) => {
            await startConvertJsonToJava(question.id, (javaCode) => {
                console.log(javaCode);
            });
        });
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const generateQuestionById = async (accessToken, questionId) => {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/questions/${questionId}`,
            { headers: { Authorization: `Bearer ${accessToken}` } }
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

const updateQuestionFiles = async () => {
    try {
        // Fetch all questions from the API
        const response = await axios.get(`${BASE_URL}/api/questions`);
        const questions = response.data;

        // Check for new questions by comparing with existing JSON files
        for (const question of questions) {
            const questionId = question.id;
            const jsonFile = path.join(__dirname, `../question/Question${questionId}`, `Question${questionId}.json`);

            // Check if JSON file already exists
            if (!fs.existsSync(jsonFile)) {
                // If not, create the directory and save the JSON file
                mkdirp.sync(path.dirname(jsonFile));
                fs.writeFileSync(jsonFile, JSON.stringify(question));
                console.log(`JSON file created for Question ${questionId}`);
            }
        }

        // Additional logic to update existing data if needed
    } catch (error) {
        console.error('Error updating question files:', error);
    }
};

const INTERVAL = 60 * 60 * 1000;
setInterval(updateQuestionFiles, INTERVAL);

websocket.on('newQuestion', () => {
    updateQuestionFiles();
});