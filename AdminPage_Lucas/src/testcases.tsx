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

export const TestCaseList = () => (
    <List>
        <Datagrid>
            <TextField source="id"/>
            <TextField source="methodSignatures"/>
            <TextField source="testComputeCase"/>
            <TextField source="input1"/>
            <TextField source="input2"/>
            <TextField source="input3"/>
            <TextField source="expectedOutput"/>
            <EditButton/>
        </Datagrid>
    </List>
);

export const TestCaseEdit = () => (
    <Edit>
        <SimpleForm>
            <TextInput source="id" InputProps={{disabled: true}}/>
            <TextInput source="methodSignatures"/>
            <TextInput source="testComputeCase"/>
            <TextInput source="input1"/>
            <TextInput source="input2"/>
            <TextInput source="input3"/>
            <TextField source="expectedOutput"/>
        </SimpleForm>
    </Edit>
);

export const TestCaseCreate = () => (
    <Create>
        <SimpleForm>
            <TextInput source="id"/>
            <TextInput source="methodSignatures"/>
            <TextInput source="testComputeCase"/>
            <TextInput source="input1"/>
            <TextInput source="input2"/>
            <TextInput source="input3"/>
            <TextField source="expectedOutput"/>
        </SimpleForm>
    </Create>
);

