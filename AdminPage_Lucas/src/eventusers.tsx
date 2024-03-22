import {
    List,
    Datagrid,
    TextField,
    ReferenceField,
    EditButton,
    SimpleForm,
    ReferenceInput,
    Edit,
    TextInput, Create
} from "react-admin";

export const EventUserList = () => (
    <List>
        <Datagrid>
            <TextField source="id"/>
            <TextField source="eventid"/>
            <TextField source="userid"/>
            <TextField source="status"/>
            <TextField source="createddate"/>
            <TextField source="createdby"/>
            <TextField source="updateddate"/>
            <TextField source="updatedby"/>
            <EditButton/>
        </Datagrid>
    </List>
);

export const EventUserEdit = () => (
    <Edit>
        <SimpleForm>
            <TextInput source="id" InputProps={{disabled: true}}/>
            <TextInput source="eventid"/>
            <TextInput source="userid"/>
            <TextInput source="status"/>
            <TextInput source="createddate"/>
            <TextInput source="createdby"/>
            <TextInput source="updateddate"/>
            <TextInput source="updatedby"/>
        </SimpleForm>
    </Edit>
);

export const EventUserCreate = () => (
    <Create>
        <SimpleForm>
            <TextInput source="eventid"/>
            <TextInput source="userid"/>
            <TextInput source="status"/>
            <TextInput source="createddate"/>
            <TextInput source="createdby"/>
            <TextInput source="updateddate"/>
            <TextInput source="updatedby"/>
        </SimpleForm>
    </Create>
);