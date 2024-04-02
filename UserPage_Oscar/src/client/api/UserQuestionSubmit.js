import axios from "axios";
import { BASE_URL } from "./config";

export const createUserQuestionSubmit = async (accessToken, userQuestionData)=> {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/userquestionsubmits`,
            userQuestionData,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getUserQuestionSubmit = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/userquestionsubmits`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const putUserQuestionSubmit = async (accessToken, id, userQuestionData)=> {
    try {
        const response = await axios.put(
            `${BASE_URL}/api/userquestionsubmits/${id}`,
            userQuestionData,
            { headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};
