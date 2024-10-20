package com.ntd.operationservice.dto;

import java.util.List;

public class JsonRpcResponse {
    private Result result;

    public JsonRpcResponse() {
    }

    public JsonRpcResponse(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private Random random;

        public Result() {
        }

        public Result(Random random) {
            this.random = random;
        }

        public Random getRandom() {
            return random;
        }

        public void setRandom(Random random) {
            this.random = random;
        }

    }

    public static class Random {
        private List<String> data;

        public Random() {
        }

        public Random(List<String> data) {
            this.data = data;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

    }
}
