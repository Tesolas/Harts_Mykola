package org.example;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class Main {
    private static final String ACCESS_TOKEN = "sl.BWfecvN3lP3M0AykJIpRrMZLI2NHfbKns3q4CUm5HdCcnNiXtyrpI_4aWrTgSM_cbIy6RzqiucFf1c0wIlYBVH37ufsEO4CkTJOgbsZyfw5GyyV68bP_IZHPI3bp_vNZofy1JwKMEj0";

    public static void main(String args[]) throws DbxException, IOException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/WebAPI_RTP").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);




        try (InputStream in = new FileInputStream("GivenFile.jpg")) {
            FileMetadata metadata = client.files().uploadBuilder("/GivenFile.jpg")
                    .uploadAndFinish(in);
        }


        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }

        Metadata metadata = client.files().delete("/GivenFile.jpg");
    }
}