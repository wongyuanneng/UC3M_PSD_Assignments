package Transport4Future.TokenManagement.Control;

import javax.json.JsonObject;

import Transport4Future.TokenManagement.Utils.TokenManagementException;

public interface IFileCheck {
    public void checkInformationFormat() throws TokenManagementException;
    public void checkJsonStruct(JsonObject jsonLicense) throws TokenManagementException;
}
