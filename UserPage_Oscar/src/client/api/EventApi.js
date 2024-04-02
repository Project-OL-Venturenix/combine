import axios from "axios";
import { BASE_URL } from "./config";

export const getEvents = async (accessToken) => {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/events`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch
        (error) {
        console.error(error);
        throw error;
    }
};

export const getEventByid = async (accessToken, id) => {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/events/${id}`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch
        (error) {
        console.error(error);
        throw error;
    }
};

export const putEventById = async (accessToken, id, status) => {
    try {
        const response = await axios.put(
            `${BASE_URL}/api/events/${id}/${status}`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch
        (error) {
        console.error(error);
        throw error;
    }
};