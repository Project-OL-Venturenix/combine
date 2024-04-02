import axios from "axios";
import { BASE_URL } from "./config";

export const getUsers = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/users`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getUserById = async (accessToken,id)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/users/${id}`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};