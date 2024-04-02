import axios from "axios";
import { BASE_URL } from "./config";

export const putGroupScores = async (accessToken, groupScoreData)=> {
    try {
        const response = await axios.post(
            `${BASE_URL}/api/groupscores`,
            groupScoreData,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        )
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};

export const getGroupScoresByEventId = async (accessToken, id)=> {
    try {
        const response = await axios.get(
            `${BASE_URL}/api/groups/eventid/${id}`,
            {headers: {Authorization: `Bearer ${accessToken}`}}
        );
        return response;
    } catch (error) {
        console.error(error);
        throw error;
    }
};