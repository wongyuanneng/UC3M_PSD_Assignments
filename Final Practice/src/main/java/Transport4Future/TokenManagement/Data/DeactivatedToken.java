package Transport4Future.TokenManagement.Data;

import java.util.HashMap;

import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfRevocation;
import Transport4Future.TokenManagement.Data.Attributes.RevocationReason;
import Transport4Future.TokenManagement.Data.Attributes.TokenValue;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.IO.RevocationParser;
import Transport4Future.TokenManagement.Store.DeactivatedTokensStore;

public class DeactivatedToken {
    private Token revokedToken;
    private TypeOfRevocation revocationType;
    private RevocationReason revocationReason;
    
    /**
     * DeactivatedToken constructor
     * @throws TokenManagementException if error occurs
     */
    public DeactivatedToken (String FileName) throws TokenManagementException {
        RevocationParser myParser = new RevocationParser();
        HashMap<String, String> items = myParser.parse(FileName);
        TokenValue tokenValue = new TokenValue(items.get(RevocationParser.TOKEN_VALUE));

        this.revokedToken = new Token();
        this.revokedToken.checkTokenExistence(tokenValue.getValue());
        this.checkPreviousRevocation(tokenValue.getValue());
        String decodedToken = this.revokedToken.decodeTokenValue(tokenValue.getValue());

        this.revokedToken = this.revokedToken.findToken(decodedToken);
        this.revokedToken.setRevoked();

        this.revocationType = new TypeOfRevocation(items.get(RevocationParser.TYPE_OF_REVOCATION));
        this.revocationReason = new RevocationReason(items.get(RevocationParser.REASON));

        store();
    }

    private void checkPreviousRevocation(String tokenToVerify) throws TokenManagementException {
        DeactivatedTokensStore myStore = DeactivatedTokensStore.getInstance();
        if (myStore.find(tokenToVerify) != null) {
            throw new TokenManagementException("Error: Token previously revoked by this method.");
        }
    }

    private void store() throws TokenManagementException {
        DeactivatedTokensStore myStore = DeactivatedTokensStore.getInstance();
        myStore.add(this);
    }


    /**
     * Returns a found token
     *
     * @throws TokenManagementException if any error occurs
     */
    public DeactivatedToken findRevokedToken(String decodedToken) throws TokenManagementException {
        DeactivatedTokensStore myStore = DeactivatedTokensStore.getInstance();        
        DeactivatedToken tokenFound = myStore.find(decodedToken);
        return tokenFound;
    }


    public Token getRevokedToken() {
        return this.revokedToken;
    }

    public String getTypeOfRevocation() {
        return this.revocationType.getValue();
    }

    public String getRevocationReason() {
        return this.revocationReason.getValue();
    }


}
