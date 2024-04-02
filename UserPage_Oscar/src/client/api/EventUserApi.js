import axios from "axios";
import { BASE_URL } from "./config";

export const getEventUsers = async (accessToken)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/eventusers`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getEventUser = async (accessToken,eventid)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/user/eventid/${eventid}`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};