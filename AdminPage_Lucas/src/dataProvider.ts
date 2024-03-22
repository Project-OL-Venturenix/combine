import { DataProvider, fetchUtils } from "react-admin";
import { stringify } from "query-string";

const apiUrl = 'http://localhost:8082/api';
const httpClient = fetchUtils.fetchJson;

const getAccessToken = () => {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user).accessToken : null;
};

const addBearerToken = (headers: any) => {
    const accessToken = getAccessToken();
    if (accessToken) {
        headers.set('Authorization', `Bearer ${accessToken}`);
    }
};

const headers = new Headers();
addBearerToken(headers);

export const dataProvider: DataProvider = {
    getList: async (resource, params) => {
        const { page, perPage } = params.pagination;
        const { field, order } = params.sort;
        const query = {
            sort: JSON.stringify([field, order]),
            range: JSON.stringify([(page - 1) * perPage, page * perPage - 1]),
            filter: JSON.stringify(params.filter),
        };
        const url = `${apiUrl}/${resource}?${stringify(query)}`;

        const { headers: responseHeaders, json } = await httpClient(url, { headers });
        return ({
            data: json,
            total: parseInt((responseHeaders.get('content-range') || "0").split('/').pop() || '0', 100),
        });
    },


    getOne: (resource, params) =>
        httpClient(`${apiUrl}/${resource}/${params.id}`, { headers }).then(({ json }) => ({
            data: json,
        })),

    getMany: (resource, params) => {
        const query = {
            filter: JSON.stringify({ id: params.ids }),
        };
        const url = `${apiUrl}/${resource}?${stringify(query)}`;
        return httpClient(url).then(({ json }) => ({ data: json }));
    },

    getManyReference: (resource, params) => {
        const { page, perPage } = params.pagination;
        const { field, order } = params.sort;
        const query = {
            sort: JSON.stringify([field, order]),
            range: JSON.stringify([(page - 1) * perPage, page * perPage - 1]),
            filter: JSON.stringify({
                ...params.filter,
                [params.target]: params.id,
            }),
        };
        const url = `${apiUrl}/${resource}?${stringify(query)}`;

        return httpClient(url).then(({ headers, json }) => ({
            data: json,
            total: parseInt((headers.get('content-range') || "0").split('/').pop() || '0', 100),
        }));
    },

    update: (resource, params) =>
        httpClient(`${apiUrl}/${resource}/${params.id}`, {
            method: 'PUT',
            body: JSON.stringify(params.data),
            headers
        }).then(({ json }) => ({ data: json })),

    updateMany: (resource, params) => {
        const query = {
            filter: JSON.stringify({ id: params.ids }),
        };
        return httpClient(`${apiUrl}/${resource}?${stringify(query)}`, {
            method: 'PUT',
            body: JSON.stringify(params.data),
        }).then(({ json }) => ({ data: json }));
    },

    create: (resource, params) =>
        httpClient(`${apiUrl}/${resource}/add`, {
            method: 'POST',
            body: JSON.stringify(params.data),
            headers
        }
        ).then(({ json }) => ({
            data: { ...params.data, id: json.id } as any,
        })),

    delete: (resource, params) =>
        httpClient(`${apiUrl}/${resource}/${params.id}`, {
            method: 'DELETE',
            headers
        }).then(({ json }) => ({ data: json })),

    deleteMany: (resource, params) => {
        const query = {
            filter: JSON.stringify({ id: params.ids }),
        };
        return httpClient(`${apiUrl}/${resource}?${stringify(query)}`, {
            method: 'DELETE',
            headers
        }).then(({ json }) => ({ data: json }));
    }
};

// import jsonServerProvider from 'ra-data-json-server';
//
// export const dataProvider = jsonServerProvider(
//     import.meta.env.VITE_JSON_SERVER_URL
// );