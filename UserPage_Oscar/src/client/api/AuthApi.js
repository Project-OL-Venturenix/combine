import axios from "axios";
import { BASE_URL } from "./config";

export const signInUser = async (userName, password) => {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/auth/signin`,
            { userName, password }
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const signUpUser = async (userData) => {
    try {
        console.log(userData)
        const response = await axios.post(
            `${BASE_URL}/api/auth/signup`,
            userData
        );
        return response;
    } catch
    (error) {
        console.error(error);
        throw error;
    }
};