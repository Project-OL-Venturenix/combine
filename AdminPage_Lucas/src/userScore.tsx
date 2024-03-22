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

export const userScoreList = () => (
  <List>
    <Datagrid>
      <TextField source="id" />
      <TextField source="event.id" />
      <TextField source="event.name" />
      <TextField source="user.id" />
      <TextField source="user.userName" />
      <TextField source="question.id" />
      <TextField source="submitTime" />
      <TextField source="resultOfPassingTestecase" />
      <TextField source="bonusUnder30Mins" />
      <TextField source="bonusWithinQuestionRuntime" />
      <TextField source="runtimebyMsec" />
      <TextField source="status" />
      <TextField source="createdDate" />
      <TextField source="updatedDate" />
      <EditButton />
    </Datagrid>
  </List>
);

export const userScoreEdit = () => (
  <Edit>
    <SimpleForm>
      <TextInput source="id" InputProps={{ disabled: true }} />
      <TextField source="event_id" />
      <TextField source="user_id" />
      <TextField source="question_id" />
      <TextField source="submitTime" />
      <TextField source="result_of_passing_testecase" />
      <TextField source="bonus_under_30_mins" />
      <TextField source="bonus_within_question_runtime" />
      <TextField source="runtimebyMsec" />
      <TextField source="status" />
      <TextField source="createdDate" />
      <TextField source="updatedDate" />
    </SimpleForm>
  </Edit>
);

export const userScoreCreate = () => (
  <Create>
    <SimpleForm>
      <TextInput source="name" required />
      <TextInput source="status" required />
      <TextInput source="createddate" />
      <TextInput source="createdby" />
      <TextInput source="updateddate" />
      <TextInput source="updatedby" />
    </SimpleForm>
  </Create>
);