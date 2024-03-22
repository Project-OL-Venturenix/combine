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

export const QuestionList = () => (
    <List>
        <Datagrid>
            <TextField source="id" />
            <TextField source="question" />
            <TextField source="testComputeCase" />
            <TextField source="methodSignatures" />
            <TextField source="targetCompleteTime" />
            <EditButton />
        </Datagrid>
    </List>
);

export const QuestionEdit = () => (
    <Edit>
        <SimpleForm>
            <TextInput source="id" InputProps={{ disabled: true }} />
            <TextInput source="question" multiline rows={5} style={{ width: "80%" }} />
            <TextInput source="testComputeCase" multiline rows={5} style={{ width: "80%" }} />
            <TextInput source="methodSignatures" multiline rows={5} style={{ width: "80%" }} />
        </SimpleForm>
    </Edit>
);

export const QuestionCreate = () => (
    <Create>
        <SimpleForm>
            <TextInput source="question" multiline rows={5} style={{ width: "80%" }} />
            <TextInput source="testComputeCase" multiline rows={5} style={{ width: "80%" }} />
            <TextInput source="methodSignatures" multiline rows={5} style={{ width: "80%" }} />
        </SimpleForm>
    </Create>
);
