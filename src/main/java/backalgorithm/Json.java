package backalgorithm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Json {

    static String textDisplay=null;


    public static void get(String str,String name,String category) throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject)jsonParser.parse(str);
        JSONArray personArray = (JSONArray) jsonObject.get("items");

        for(int i=0;i<personArray.size();i++){
            JSONObject itemObject = (JSONObject) personArray.get(i);
            JSONObject snippetObject =  (JSONObject)itemObject.get("snippet");
            JSONObject topLevelComment =  (JSONObject)snippetObject.get("topLevelComment");
            JSONObject snippetCoreObject =  (JSONObject)topLevelComment.get("snippet");
            int like = Integer.parseInt(snippetCoreObject.get("likeCount").toString());
            if(like > 5){
                textDisplay += snippetCoreObject.get("textDisplay").toString();
                System.out.println(like);
            }
        }

        File file = new File("D:\\politicsdata\\"+name+"_"+category+".txt");
        FileWriter writer = null;

        if(file.exists()){
            try {
                // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
                writer = new FileWriter(file, true);
                writer.write(textDisplay);
                writer.flush();
                System.out.println("DONE");
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(writer != null) writer.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            file.createNewFile();
        }
    }

    public static void main(String[] args) throws ParseException, IOException {
        String origin = "{\"etag\":\"7x5b9m4l0aPsOtWhpfskwDrHrzk\",\"items\":[{\"etag\":\"cZKwJBydYrvtFdWL4lOLNeRWWnw\",\"id\":\"UgzCUWNUffLyj1GRn4R4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"gYECdljFYLRsI30GaQabVBHT26I\",\"id\":\"UgzCUWNUffLyj1GRn4R4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCmr6dU_eOqXYvf_yTFcJTpA\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCmr6dU_eOqXYvf_yTFcJTpA\",\"authorDisplayName\":\"세븐나이트\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLQY-Lfn1VZllAqM1Vr16HyTXTLpqIIxpwCIHIUE=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":39,\"publishedAt\":\"2021-03-06T12:12:47.000Z\",\"textDisplay\":\"이번 영화는 윈드 토커(Windtalkers) 2002년작 입니다\\r\\n올해에도 좋은일만 가득하시길 바랍니다\\r\\n항상 감사합니다\",\"textOriginal\":\"이번 영화는 윈드 토커(Windtalkers) 2002년작 입니다\\r\\n올해에도 좋은일만 가득하시길 바랍니다\\r\\n항상 감사합니다\",\"updatedAt\":\"2021-03-06T12:12:47.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":4,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"63tWwoeWO5IkXUktHbUeH8BDMDI\",\"id\":\"UgwnHfXi3OoN-JRpg6h4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"XZ6oDtN1XuIi7CT5rTK88dhAzH4\",\"id\":\"UgwnHfXi3OoN-JRpg6h4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UC5QxWYT-PR4EssFki8NhOTA\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UC5QxWYT-PR4EssFki8NhOTA\",\"authorDisplayName\":\"이태영\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLQHcb85SZN2mv7QK6qwGG2L3Xp_H8QQMpTasw=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":1,\"publishedAt\":\"2021-07-12T19:54:09.000Z\",\"textDisplay\":\"정보 감사합니다  오우삼 감독님, 나바호족 따봉~~♡\",\"textOriginal\":\"정보 감사합니다  오우삼 감독님, 나바호족 따봉~~♡\",\"updatedAt\":\"2021-07-12T19:54:09.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"Z9IOZBZH7eL9EvW8ifmIniUBoO8\",\"id\":\"Ugx20fJu9HpOfEbPzvd4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"1olT9QUF3_ypfjUJUdCrKZVDSYM\",\"id\":\"Ugx20fJu9HpOfEbPzvd4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UC4GTfeC5rGJd92KZ6kfTe7Q\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UC4GTfeC5rGJd92KZ6kfTe7Q\",\"authorDisplayName\":\"광철광철\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLTMmgfqui9k_nco2xJe70JvFdMfTh3UIpL-Wp4wnQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-11T01:48:17.000Z\",\"textDisplay\":\"마동석씨   맞죠??\",\"textOriginal\":\"마동석씨   맞죠??\",\"updatedAt\":\"2021-07-11T01:48:17.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"BqKuXB1gMJBAPyTczoMhtEhT2Oo\",\"id\":\"Ugzz913evuPTrr79jHh4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"ydeWhh-qVzJ9yQc7S873CC0g8iI\",\"id\":\"Ugzz913evuPTrr79jHh4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCXgl8Bl7icygymPywZdqgdQ\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCXgl8Bl7icygymPywZdqgdQ\",\"authorDisplayName\":\"MAYA PROJECT\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLRH58PCeMJCMxEVP0MFiQ24Bvw2ivTCozhFKNMq=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-11T01:13:01.000Z\",\"textDisplay\":\"Podo ngomong opo wae uwong-uwong iki yooo. ..?..bingung dewe aq..?.\\uD83D\\uDE03\\uD83D\\uDE03\",\"textOriginal\":\"Podo ngomong opo wae uwong-uwong iki yooo. ..?..bingung dewe aq..?.\\uD83D\\uDE03\\uD83D\\uDE03\",\"updatedAt\":\"2021-07-11T01:13:01.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"tSYAYlv1W8XKX3GnZdpHbK1X84Q\",\"id\":\"Ugx-QNhKQhmkQq2BDk54AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"PRFuxwPXT-EmNZjsQm1KbVJsOg0\",\"id\":\"Ugx-QNhKQhmkQq2BDk54AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCOMw8JL8HjD88Ofp6Wqe_fQ\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCOMw8JL8HjD88Ofp6Wqe_fQ\",\"authorDisplayName\":\"M1269 P\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLTOG_8wtvDfmrlGTM2KGDfFZ7v_2clBxmCRwI9shw=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-10T12:17:12.000Z\",\"textDisplay\":\"다 좋은데 나레이션이 사투리가 남도 사투리\",\"textOriginal\":\"다 좋은데 나레이션이 사투리가 남도 사투리\",\"updatedAt\":\"2021-07-10T12:17:12.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":1,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"5Lq1z84L86xzsa8Zq-xhsukzkXY\",\"id\":\"UgwpzzI4adjPUpE-Zth4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"DTfU7UA77AfEzuHhC58a55cv9KU\",\"id\":\"UgwpzzI4adjPUpE-Zth4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCeZjfFrcVL90ZKylvcPXnjA\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCeZjfFrcVL90ZKylvcPXnjA\",\"authorDisplayName\":\"마지막 제작자\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/XJswcRBgCmY8Z7_VvfIQV38LmFRqrGIS_K5cbbXU-gEzPsn4JXkMbeBht6b6Id1pyaD1EraBKA=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-09T14:31:22.000Z\",\"textDisplay\":\"슬픔\",\"textOriginal\":\"슬픔\",\"updatedAt\":\"2021-07-09T14:31:22.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"80d4ajblUnX8YeKj_VHgHjmObjc\",\"id\":\"UgzkXn7UcNOhGtG-j4B4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"kqm3_CAN3Z9Gwq4A9IUswU6tjz4\",\"id\":\"UgzkXn7UcNOhGtG-j4B4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCCc6YcMzmM5uHg9CcNLX4gw\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCCc6YcMzmM5uHg9CcNLX4gw\",\"authorDisplayName\":\"Jade Kang\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLTTWkRj-eGel2vVtN82wQK-GwK5dSwNSVOOSQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":1,\"publishedAt\":\"2021-07-08T20:24:46.000Z\",\"textDisplay\":\"8:43 캘리포니아 소재 가 아니라 uss california 라는 해군 함선입니다\",\"textOriginal\":\"8:43 캘리포니아 소재 가 아니라 uss california 라는 해군 함선입니다\",\"updatedAt\":\"2021-07-08T20:24:46.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"rb1LU8yf3027gD7FZyaDbhO8O5Y\",\"id\":\"UgwDaAwq44cvgTm3Anh4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"4hza6HKTYFk8MQ9r73_88T6E0Tg\",\"id\":\"UgwDaAwq44cvgTm3Anh4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCUBjLPHXIrfpU7sbBmOqzKQ\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCUBjLPHXIrfpU7sbBmOqzKQ\",\"authorDisplayName\":\"아무개\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLR32CIPWsUTFtG0OncUMyb9TPuOv_hFQmZ5zbNw=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-08T09:31:54.000Z\",\"textDisplay\":\"우리 6.25 전쟁에서 활약을 해줬다니 참으로 고맙네요!\",\"textOriginal\":\"우리 6.25 전쟁에서 활약을 해줬다니 참으로 고맙네요!\",\"updatedAt\":\"2021-07-08T09:31:54.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"0T8jNXfW0g4Yyt57WA6wrpfX5D4\",\"id\":\"UgwVWMPSckXUL-_zklN4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"XeE-dqHHEfP_TyjT6PQEx_He3-M\",\"id\":\"UgwVWMPSckXUL-_zklN4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UC7cO5MnC9YrA46qTglR7CYA\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UC7cO5MnC9YrA46qTglR7CYA\",\"authorDisplayName\":\"A Tâm\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLQh7_VwuLgMFjNV3cjdHE790s5ooGSBiWh3M4-4=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-07T07:18:59.000Z\",\"textDisplay\":\"Nhật Bản rất anh dũng nhưng tiếc...cho đất nước đế quốc tàn nhẫn\",\"textOriginal\":\"Nhật Bản rất anh dũng nhưng tiếc...cho đất nước đế quốc tàn nhẫn\",\"updatedAt\":\"2021-07-07T07:18:59.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"oDUVZ_EAMOJSx97PAiWakuMqg28\",\"id\":\"Ugzz1NpVzK9uQ0rrds94AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"-UGYDXL2DsHeEttN58UI2-O4WZA\",\"id\":\"Ugzz1NpVzK9uQ0rrds94AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCzs3qE8mffauGaVtP5uKScg\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCzs3qE8mffauGaVtP5uKScg\",\"authorDisplayName\":\"위대한 민족\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLTEKOpMxN3k5kec19cmLZsTdaWcJRpm92jYhQ=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-05T14:18:04.000Z\",\"textDisplay\":\"625전쟁 때 제주도방언을 암호로 사용 하였답니다\",\"textOriginal\":\"625전쟁 때 제주도방언을 암호로 사용 하였답니다\",\"updatedAt\":\"2021-07-05T14:18:04.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"FaZohOKtgqaJ4SlECgKn4i_kvhs\",\"id\":\"Ugx63ruDYV_olOerlvV4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"4n8duYwk3qCafgPGnNzUQJT3asM\",\"id\":\"Ugx63ruDYV_olOerlvV4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCsg2hkpCW0UtxKz7ydOUR2Q\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCsg2hkpCW0UtxKz7ydOUR2Q\",\"authorDisplayName\":\"류셰프라이프Ryuchef Life\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLR3WreE7HjUg_Y0q_IrCkHIIod3Gy_ed0baXIA3pw=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-05T10:22:29.000Z\",\"textDisplay\":\"명작이네요.. 니콜라스 케이지 형이 날라다니던 시절에 나온 영화이군요..\\n너무 잘봤습니다\",\"textOriginal\":\"명작이네요.. 니콜라스 케이지 형이 날라다니던 시절에 나온 영화이군요..\\n너무 잘봤습니다\",\"updatedAt\":\"2021-07-05T10:22:29.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"LH2UApALGIvCmPWZWdhWnPHjbo8\",\"id\":\"UgxmMIwjFXJTTDLioy14AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"PFJSL1eaklhPD3s7em1zMFe0q60\",\"id\":\"UgxmMIwjFXJTTDLioy14AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCoAzSD2CJu1R-aRizbjFnsA\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCoAzSD2CJu1R-aRizbjFnsA\",\"authorDisplayName\":\"Владимир Свитогор\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLSR_2ZDTRQTK9q_WbLdf5L9ioQ08rvuK1QO1Q=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-04T17:33:10.000Z\",\"textDisplay\":\"Что за фильм.\",\"textOriginal\":\"Что за фильм.\",\"updatedAt\":\"2021-07-04T17:33:10.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"c-6rZWhtihxM8BesYb6F3d8jWXA\",\"id\":\"UgxJL5F2SKAqy_J5vKB4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"IxFfRx9BiNXzdm-8yqPVq4-dwj8\",\"id\":\"UgxJL5F2SKAqy_J5vKB4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCHqZEKD8PUNtgRV1-rLD34w\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCHqZEKD8PUNtgRV1-rLD34w\",\"authorDisplayName\":\"손영준\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLSb40EhIVeMZjfZRBedeCsuvfIXz1ehpIEwtJTSag=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":11,\"publishedAt\":\"2021-07-04T01:01:59.000Z\",\"textDisplay\":\"7:43 와 희생정신 쩐다\",\"textOriginal\":\"7:43 와 희생정신 쩐다\",\"updatedAt\":\"2021-07-04T01:01:59.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"EfUpyocTLGCOwQMirQk0dXPkdcE\",\"id\":\"UgyjMWM_FTleXm_Xkbt4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"fr_w4ZThWaXFFss3O9_OoyGwtK0\",\"id\":\"UgyjMWM_FTleXm_Xkbt4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCV_OHzBA29JaHLPTa6xuKjg\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCV_OHzBA29JaHLPTa6xuKjg\",\"authorDisplayName\":\"Jam Bread\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLQSyFTFlV_suwIGVxGqYJRJZHA8cVtF5yM1oL1J=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-03T14:49:36.000Z\",\"textDisplay\":\"3:34 루시우스 말포이~!(해리 포터)\",\"textOriginal\":\"3:34 루시우스 말포이~!(해리 포터)\",\"updatedAt\":\"2021-07-03T14:49:36.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"Ano8ZEwAO2cS3Zm4t4NhSjpCl_U\",\"id\":\"Ugx8FPNZxYBVNFwzZCF4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"lD78fTCBE-ia5OSjUpgfYU0g964\",\"id\":\"Ugx8FPNZxYBVNFwzZCF4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCm1NW0Hzw9gjJAtLvfYXO2A\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCm1NW0Hzw9gjJAtLvfYXO2A\",\"authorDisplayName\":\"Jayzel Flores\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/a/default-user=s48\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-03T06:37:57.000Z\",\"textDisplay\":\"Gtr\",\"textOriginal\":\"Gtr\",\"updatedAt\":\"2021-07-03T06:37:57.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"FizAQ46COTpw9l5S2v2dYt8inPY\",\"id\":\"UgwX7rBPJODD1-RXK7J4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"-eOpbBt9C2T3hxXxof14LLZBmJE\",\"id\":\"UgwX7rBPJODD1-RXK7J4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCh16XP0DZC1R5yoj9t9UW1Q\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCh16XP0DZC1R5yoj9t9UW1Q\",\"authorDisplayName\":\"Gatsby\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLTIwg4q9lkIoi7ys19HG-1fCbe00-H6SSfMnWAHWg=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-02T11:02:18.000Z\",\"textDisplay\":\"참고로 오폭은 오발사격은 현대전에서도 빈번히 발생합니다ㅜㅜ 미국ㅜㅜ\",\"textOriginal\":\"참고로 오폭은 오발사격은 현대전에서도 빈번히 발생합니다ㅜㅜ 미국ㅜㅜ\",\"updatedAt\":\"2021-07-02T11:02:18.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"wAGQj28hI23BkW93x7bVS-gs4O8\",\"id\":\"UgxXFJE-cc3xVWGq7ZN4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"KuBjGCua8ros7rAsAe3WlqymPN4\",\"id\":\"UgxXFJE-cc3xVWGq7ZN4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UC_JW04jS-Z4e8bn8QJPPnAA\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UC_JW04jS-Z4e8bn8QJPPnAA\",\"authorDisplayName\":\"Tin Hot 247\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/nXqQXnNAV3265XqiHiWDoiVAefFR3UTaZT37byEJQaVdyimPAzXKDfVIdKdALKO1hOl9TO-K=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-01T18:46:13.000Z\",\"textDisplay\":\"Name Film\",\"textOriginal\":\"Name Film\",\"updatedAt\":\"2021-07-01T18:46:13.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"4EwY0hjOCagS8NiiIWGT-oJVSSw\",\"id\":\"Ugxe1NKkbU93-Y7QNHd4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"Gx-OSIcjWF-So7MBX-jbvH6KTfQ\",\"id\":\"Ugxe1NKkbU93-Y7QNHd4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCFoXMAqEYzshTTrTkGXXXMw\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCFoXMAqEYzshTTrTkGXXXMw\",\"authorDisplayName\":\"문재인\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLQT4m15SB3zwHJZmsRT-eDMZmgU817Aif3FBLi4=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":3,\"publishedAt\":\"2021-07-01T17:13:56.000Z\",\"textDisplay\":\"이분 목소리가 ... 마동석인가유 매우닮았네여\",\"textOriginal\":\"이분 목소리가 ... 마동석인가유 매우닮았네여\",\"updatedAt\":\"2021-07-01T17:13:56.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"DKZIS4zAscj7A7_T5XKFKAm8IUw\",\"id\":\"UgwOgyivh3Cm9ft9VHR4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"0RN_xEwIyPtCi4dEv0bDOdeRqs0\",\"id\":\"UgwOgyivh3Cm9ft9VHR4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UCDsEXmdQcSmqdY2J7-stq3A\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UCDsEXmdQcSmqdY2J7-stq3A\",\"authorDisplayName\":\"요즈님 공식 0호팬!김레고\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLSFfAVimtflmL3CUEjyz3rUzd_xA22Ocho0OU3r=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-07-01T09:40:16.000Z\",\"textDisplay\":\"한국보다 전쟁 순위 더 낮은 일본이 전쟁1위 미국을 공격하는게 더 어이없음........\",\"textOriginal\":\"한국보다 전쟁 순위 더 낮은 일본이 전쟁1위 미국을 공격하는게 더 어이없음........\",\"updatedAt\":\"2021-07-01T09:40:16.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":1,\"videoId\":\"KAotIgfV2b8\"}},{\"etag\":\"6eEz_w0TTaTnu220T2R-C15TsLM\",\"id\":\"UgzIQY3X3rMei4_rYuB4AaABAg\",\"kind\":\"youtube#commentThread\",\"snippet\":{\"canReply\":true,\"isPublic\":true,\"topLevelComment\":{\"etag\":\"JoiqaS5ozNOG6eUgDqJLVEztYtc\",\"id\":\"UgzIQY3X3rMei4_rYuB4AaABAg\",\"kind\":\"youtube#comment\",\"snippet\":{\"authorChannelId\":{\"value\":\"UC4UmHj2O0ABVGN5qGQ_CwTw\"},\"authorChannelUrl\":\"http://www.youtube.com/channel/UC4UmHj2O0ABVGN5qGQ_CwTw\",\"authorDisplayName\":\"sunsuk lee\",\"authorProfileImageUrl\":\"https://yt3.ggpht.com/ytc/AKedOLRemOEX4je5Dk5UuGVel79FwZGcJiamHM9S8Q=s48-c-k-c0x00ffffff-no-rj\",\"canRate\":true,\"likeCount\":0,\"publishedAt\":\"2021-06-30T18:42:47.000Z\",\"textDisplay\":\"전쟁은 교육이잘못된자들이 삐뚤어진욕심때문이다...\",\"textOriginal\":\"전쟁은 교육이잘못된자들이 삐뚤어진욕심때문이다...\",\"updatedAt\":\"2021-06-30T18:42:47.000Z\",\"videoId\":\"KAotIgfV2b8\",\"viewerRating\":\"none\"}},\"totalReplyCount\":0,\"videoId\":\"KAotIgfV2b8\"}}],\"kind\":\"youtube#commentThreadListResponse\",\"nextPageToken\":\"QURTSl9pMjhzTExNcU1kOHJuSjZZR1RLdEtmM0hXNEtHQ05nQU5Pa216TEU3elZseWlRZW92cmJZd19kMmYxQ2NvX0ZYb2dQQlZEaExlQzBpdmRVN1JydnJmU3NpTzRoQ0E=\",\"pageInfo\":{\"resultsPerPage\":20,\"totalResults\":20}}\n";
        get(origin,"이준석","경제");
    }


}
