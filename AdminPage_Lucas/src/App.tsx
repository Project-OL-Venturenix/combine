import { Admin, Resource, ShowGuesser } from "react-admin";
import authProvider from "./authProvider";
import { dataProvider } from './dataProvider';
import { EventCreate, EventEdit, EventList } from "./events";
import { userScoreList, userScoreEdit, userScoreCreate } from "./userScore";
import { QuestionCreate, QuestionEdit, QuestionList } from "./questions";
import { TestCaseCreate, TestCaseEdit, TestCaseList } from "./testcases";
import { UserCreate, UserEdit, UserList } from "./users";

export const App = () => (
    <Admin dataProvider={dataProvider} authProvider={authProvider}>
        <Resource name="events" list={EventList} edit={EventEdit} create={EventCreate} />
        <Resource name="questions" list={QuestionList} edit={QuestionEdit} create={QuestionCreate} />
        <Resource name="testcases" list={TestCaseList} edit={TestCaseEdit} create={TestCaseCreate} />
        {/* <Resource name="events" list={EventQuestionList} edit={EventQuestionEdit} create={EventQuestionCreate} /> */}
        <Resource name="users" list={UserList} show={ShowGuesser} edit={UserEdit} create={UserCreate} />
        <Resource name="userscores" list={userScoreList} edit={userScoreEdit} create={userScoreCreate} />
        {/* <Resource name="eventusers" list={EventUserList} edit={EventUserEdit} create={EventUserCreate} />
        <Resource name="groups" list={GroupList} edit={GroupEdit} create={GroupCreate} />
        <Resource name="groupusers" list={GroupUserList} edit={GroupUserEdit} create={GroupUserCreate} />
        <Resource name="eventgroups" list={EventGroupList} edit={EventGroupEdit} create={EventGroupCreate} /> */}
    </Admin>
);