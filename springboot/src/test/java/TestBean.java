import java.util.List;

public class TestBean {


    /**
     * code : 0
     * data : [{"username":"小王"},{"username":"小张"}]
     */

    private int code;
    private List<DataParkingInfo> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataParkingInfo> getData() {
        return data;
    }

    public void setData(List<DataParkingInfo> data) {
        this.data = data;
    }

    public static class DataParkingInfo {
        /**
         * username : 小王
         */

        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
