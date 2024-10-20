package com.ntd.operationservice.dto;

public class JsonRpcRequest {
    private String jsonrpc;
    private String method;
    private Params params;
    private int id;

    public JsonRpcRequest(String jsonrpc, String method, Params params, int id) {
        this.jsonrpc = jsonrpc;
        this.method = method;
        this.params = params;
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonRpcRequest() {
        this.jsonrpc = "2.0";
        this.method = "generateStrings";
        this.params = new Params();
        this.id = 42;
    }
    public static class Params {
        private String apiKey;
        private int n;
        private int length;
        private String characters;

        public Params() {
            this.apiKey = "f451e686-7ce7-42a0-9d9c-bf327a1490ab";
            this.n = 1;
            this.length = 10;
            this.characters = "abcdefghijklmnopqrstuvwxyz";

        }


        public Params(String apiKey, int n, int length, String characters) {
            this.apiKey = apiKey;
            this.n = n;
            this.length = length;
            this.characters = characters;
        }

        public String getApiKey() {
            return apiKey;
        }

        public void setApiKey(String apiKey) {
            this.apiKey = apiKey;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getCharacters() {
            return characters;
        }

        public void setCharacters(String characters) {
            this.characters = characters;
        }
    }


}
