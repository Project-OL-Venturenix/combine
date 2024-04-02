import axios from "axios";
import { BASE_URL } from "./config";

export const getGroupUsers = async (accessToken, eventId) => {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/groups/${eventId}`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch
        (error) {
        console.error(error);
        throw error;
    }
};
