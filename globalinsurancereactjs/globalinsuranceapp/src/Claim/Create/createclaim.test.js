import axios from "axios";
import { renderHook, act } from 'react-hooks-testing-library';
import apiCaller, {BASE_URL, Fetch, fetchUsers} from "./create";
import MockAdapter from "axios-mock-adapter";
import {render, waitFor} from "@testing-library/react";
jest.mock("axios");

describe("fetchUsers", () => {
    describe("when API call is successful", () => {
        it("should return users list", async () => {
            // given
            const users = [
                { id: 1, name: "John" },
                { id: 2, name: "Andrew" },
            ];
            axios.get.mockResolvedValueOnce(users);

            // when
            const result = await fetchUsers();

            // then
            expect(axios.get).toHaveBeenCalledWith(`${BASE_URL}/users`);
            expect(result).toEqual(users);
        });
    });

    describe("when API call fails", () => {
        it("should return empty users list", async () => {
            // given
            const message = "Network Error";
            axios.get.mockRejectedValueOnce(new Error(message));

            // when
            const result = await fetchUsers();

            // then
            expect(axios.get).toHaveBeenCalledWith(`${BASE_URL}/users`);
            expect(result).toEqual([]);
        });
    });


    it('should set rawData properly when api call is successfull because of', async () => {
        axios.get.mockResolvedValueOnce({ data: { test: '123' } });
        const { result, waitForNextUpdate } = renderHook(() => apiCaller());
        await act(async () => {
            result.current.callApi('fb/tsla');
            await waitForNextUpdate();
        });
        expect(result.current.rawApiData.data.test).toBe('123');
    });

    it("fetches and displays data", async () => {
        // We'll be explicit about what data Axios is to return when `get` is called.
        axios.get.mockResolvedValueOnce({ data: { greeting: "hello there" } });

        // Let's render our Fetch component, passing it the url prop and destructuring
        // the `getByTestId` function so we can find individual elements.
        const url = "/greeting";
        const { getByTestId } = render(<Fetch url={url} />);

        // On first render, we expect the "loading" span to be displayed
        expect(getByTestId("loading")).toHaveTextContent("Loading data...");

        // Because the useAxios call (useEffect) happens after initial render
        // We need to handle the async nature of an AJAX call by waiting for the
        // element to be rendered.
        const resolvedSpan = await waitFor(() => getByTestId("resolved"));

        // Now with the resolvedSpan in hand, we can ensure it has the correct content
        expect(resolvedSpan).toHaveTextContent("hello there");
        // Let's also make sure our Axios mock was called the way we expect
        expect(axios.get).toHaveBeenCalledTimes(1);
        expect(axios.get).toHaveBeenCalledWith(url);
    });

});
