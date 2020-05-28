package Transport4Future.TokenManagement.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

import Transport4Future.TokenManagement.TokenManager;
import Transport4Future.TokenManagement.Data.Token;
import Transport4Future.TokenManagement.Data.Attributes.TypeOfRevocation;
import Transport4Future.TokenManagement.Data.Attributes.RevocationReason;
import Transport4Future.TokenManagement.Data.Attributes.TokenValue;
import Transport4Future.TokenManagement.Exceptions.TokenManagementException;
import Transport4Future.TokenManagement.IO.RevocationParser;
import Transport4Future.TokenManagement.Store.TokensRequestStore;
import Transport4Future.TokenManagement.Store.TokensStore;
import Transport4Future.TokenManagement.Store.DeactivatedTokensStore;
import Transport4Future.Utils.SHA256Hasher;

public class DeactivatedToken {
	private Token revokedToken;
    private TypeOfRevocation revocationType;
    private RevocationReason revocationReason;
    //private String tokenValue;
    /**
     * Token constructor
     * @throws TokenManagementException 
     *
     * 
     */
    public DeactivatedToken (String FileName) throws TokenManagementException {
        RevocationParser myParser = new RevocationParser();
        HashMap<String, String> items = myParser.parse(FileName);
        TokenValue tokenValue = new TokenValue(items.get(RevocationParser.TOKEN_VALUE));
        this.verifyDeactivatedToken(tokenValue.getValue());
        this.revokedToken = new Token();
        String decodedToken = this.revokedToken.decodeTokenValue(tokenValue.getValue());
        this.revokedToken = this.revokedToken.findToken(decodedToken);
        this.revokedToken.setRevoked();
        this.revocationType = new TypeOfRevocation(items.get(RevocationParser.TYPE_OF_REVOCATION));
        this.revocationReason = new RevocationReason(items.get(RevocationParser.REASON));

        store();
    }

    public DeactivatedToken() {

    }
    
    private void alreadyRevoked() throws TokenManagementException{
    	
    }
    
    private void verifyDeactivatedToken(String tokenToVerify) throws TokenManagementException{
    	DeactivatedTokensStore myStore = DeactivatedTokensStore.getInstance();
        if (myStore.find(tokenToVerify) != null) {
            throw new TokenManagementException("Error: Token previously revoked by this method.");
        }
    	TokenManager myManager = TokenManager.getInstance();
        if (!myManager.verifyToken(tokenToVerify)) {
            throw new TokenManagementException("The token received does not exist.");
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
