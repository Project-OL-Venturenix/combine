import axios from "axios";
import { BASE_URL } from "./config";

export const addEventGroupUserQuestionHandle = async (accessToken, questionData)=> {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/groupuserquestionhandle/add`,
            questionData,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getEventGroupUserQuestionHandle = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/groupuserquestionhandles`,

            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const putEventGroupUserQuestionHandle = async (accessToken, id, questionData) => {
    try {
        const updatedResponse = await axios.put(
            `${BASE_URL}/api/groupuserquestionhandles/${id}`,
            questionData,
            { headers: { Authorization: `Bearer ${accessToken}` } }
        );
        return updatedResponse;
    } catch (error) {
        console.error(error);
        throw error;
    }
};