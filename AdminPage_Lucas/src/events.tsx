import {
    Create,
    Datagrid,
    Edit,
    EditButton,
    List,
    SimpleForm,
    TextField,
    TextInput
} from "react-admin";

export const EventList = () => (
    <List>
        <Datagrid>
            <TextField source="id"/>
            <TextField source="eventDate"/>
            <TextField source="name"/>
            <TextField source="status"/>
            <TextField source="targetStartTime"/>
            <TextField source="targetEndTime"/>
            <TextField source="createdDate"/>
            <TextField source="createdBy"/>
            <TextField source="updatedDate"/>
            <TextField source="updatedBy"/>
            <EditButton/>
        </Datagrid>
    </List>
);

export const EventEdit = () => (
    <Edit>
        <SimpleForm>
            <TextInput source="id" InputProps={{disabled: true}}/>
            <TextInput source="eventDate"/>
            <TextInput source="name"/>
            <TextInput source="status"/>
            <TextInput source="targetStartTime"/>
            <TextInput source="targetEndTime"/>
            <TextInput source="createdDate"/>
            <TextInput source="createdBy"/>
            <TextInput source="updatedDate"/>
            <TextInput source="updatedBy"/>
        </SimpleForm>
    </Edit>
);

export const EventCreate = () => (
    <Create>
        <SimpleForm>
            <TextInput source="name" required/>
            <TextInput source="status" required/>
            <TextInput source="eventDate"/>
            <TextInput source="targetStartTime"/>
            <TextInput source="targetEndTime"/>
        </SimpleForm>
    </Create>
);