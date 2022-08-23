import axios from "axios";


import {ClaimCreate,url} from "./create";
import {queryByAttribute, render, waitFor} from "@testing-library/react";


jest.mock("axios");

const fakeUsers = [
    {
        id: 1,
        name: "Test User 1",
        username: "testuser1",
    },
    {
        id: 2,
        name: "Test User 2",
        username: "testuser2",
    },
];

describe("App component",  () => {
    test("it renders", async () => {
        axios.get.mockResolvedValue({ data: fakeUsers });
        render(<ClaimCreate />);

        expect(screen.getByText("Users:")).toBeInTheDocument();
    });



    test('axios call', async() => {

        // await waitFor(() =>{
        axios.get.mockResolvedValue({ data: fakeUsers });
        // });

        const { getByTestId } = render(<ClaimCreate/>)
        const Values = await waitFor(() =>
            getByTestId("user-item")
        );
        expect(screen.getByTestId("user-item")).toBeInTheDocument();

    });





});



