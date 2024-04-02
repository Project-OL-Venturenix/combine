import axios from "axios";
import { BASE_URL } from "./config";

export const putUserTestCase = async (accessToken, userTestCaseData)=> {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/usertestcases`,
            userTestCaseData,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getUserTestCase = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/usertestcases`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};
