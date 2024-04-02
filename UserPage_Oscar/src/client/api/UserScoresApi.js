import axios from "axios";
import { BASE_URL } from "./config";

export const createUserScores = async (accessToken, userScoreData)=> {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/userscores/addScore`,
            null,
            {
            params:userScoreData,
            headers: {Authorization: `Bearer ${accessToken}`}
            }
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const putUserScores = async (accessToken, id, userScoreData)=> {
    try {
        const response = await axios.put(
            `${BASE_URL}/api/userscores/${id}`,
            userScoreData,
            { headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getUserScores = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/userscores`,
            { headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getUserScoresByEventId = async (accessToken, id)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/usertestcases/eventid/${id}`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const addUserScores = async (accessToken, userScoreData, userQuestionData)=> {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/userscores/addScore`,
            userQuestionData,
            {
                params:userScoreData,
                headers: {Authorization: `Bearer ${accessToken}`}
            }
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const updateUserScores = async (accessToken, userScoreData, userQuestionData)=> {
    try {
        const response = await axios.put(
            `${BASE_URL}/api/userscores/updateScore`,
            userQuestionData,
            {
                params:userScoreData,
                headers: {Authorization: `Bearer ${accessToken}`}
            }
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};


