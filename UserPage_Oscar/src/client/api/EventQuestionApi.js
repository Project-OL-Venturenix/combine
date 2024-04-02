import axios from "axios";
import { BASE_URL } from "./config";

export const getEventQuestions = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/eventquestions`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};