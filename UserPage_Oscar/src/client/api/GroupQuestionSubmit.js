import axios from "axios";
import { BASE_URL } from "./config";

export const putGroupQuestionSubmit = async (accessToken, groupQuestionData)=> {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/groupquestionsubmits`,
            groupQuestionData,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getGroupQuestionSubmit = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/groupquestionsubmits`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};
