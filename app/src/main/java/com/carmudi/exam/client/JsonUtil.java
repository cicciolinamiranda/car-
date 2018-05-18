package com.carmudi.exam.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * Created by cicciolina on 5/18/18.
 */

public class JsonUtil {
    public static GsonBuilder gsonBuilder;

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
    }

    public static Gson getGson() {
        return gsonBuilder.create();
    }

//    public static String serialize(Object obj){
//        return getGson().toJson(obj);
//    }

    public static <T> T deserializeToList(String jsonString, Class cls){
        return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
    }

    public static <T> T deserializeToObject(String jsonString, Class cls){
        return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
    }

    public static Type getListTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();

//        if ("CommentModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<CommentModel>>(){}.getType();
//        }
//
//        if ("DeviceModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<DeviceModel>>(){}.getType();
//        }
//
//        if ("DevicePhotoModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<DevicePhotoModel>>(){}.getType();
//        }
//
//        if ("DevicePhotoObjectModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<DevicePhotoObjectModel>>(){}.getType();
//        }
//
//        if ("FlagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<FlagModel>>(){}.getType();
//        }
//
//        if ("LocationModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<LocationModel>>(){}.getType();
//        }
//
//        if ("OrganizationModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<OrganizationModel>>(){}.getType();
//        }
//
//        if ("PatchDeviceModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<PatchDeviceModel>>(){}.getType();
//        }
//
//        if ("PushMetricEnvelopeModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<PushMetricEnvelopeModel>>(){}.getType();
//        }
//
//        if ("PushMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<PushMetricModel>>(){}.getType();
//        }
//
//        if ("QueryMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<QueryMetricModel>>(){}.getType();
//        }
//
//        if ("RadioModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<RadioModel>>(){}.getType();
//        }
//
//        if ("ResponseCommentModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseCommentModel>>(){}.getType();
//        }
//
//        if ("ResponseDeviceModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseDeviceModel>>(){}.getType();
//        }
//
//        if ("ResponseDevicePhotosModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseDevicePhotosModel>>(){}.getType();
//        }
//
//        if ("ResponseErrorModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseErrorModel>>(){}.getType();
//        }
//
//        if ("ResponseFlagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseFlagModel>>(){}.getType();
//        }
//
//        if ("ResponseMetadataModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseMetadataModel>>(){}.getType();
//        }
//
//        if ("ResponseOrganizationModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseOrganizationModel>>(){}.getType();
//        }
//
//        if ("ResponseQueryMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseQueryMetricModel>>(){}.getType();
//        }
//
//        if ("ResponseRadioModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseRadioModel>>(){}.getType();
//        }
//
//        if ("ResponseStatusModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseStatusModel>>(){}.getType();
//        }
//
//        if ("ResponseSummaryModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseSummaryModel>>(){}.getType();
//        }
//
//        if ("ResponseTagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseTagModel>>(){}.getType();
//        }
//
//        if ("ResponseVenueModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResponseVenueModel>>(){}.getType();
//        }
//
//        if ("ResultsQueryMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<ResultsQueryMetricModel>>(){}.getType();
//        }
//
//        if ("SummaryModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<SummaryModel>>(){}.getType();
//        }
//
//        if ("TagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<TagModel>>(){}.getType();
//        }
//
//        if ("VenueModel".equalsIgnoreCase(className)) {
//            return new TypeToken<List<VenueModel>>(){}.getType();
//        }

        return new TypeToken<List<Object>>(){}.getType();
    }

    public static Type getTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();

//        if ("CommentModel".equalsIgnoreCase(className)) {
//            return new TypeToken<CommentModel>(){}.getType();
//        }
//
//        if ("DeviceModel".equalsIgnoreCase(className)) {
//            return new TypeToken<DeviceModel>(){}.getType();
//        }
//
//        if ("DevicePhotoModel".equalsIgnoreCase(className)) {
//            return new TypeToken<DevicePhotoModel>(){}.getType();
//        }
//
//        if ("DevicePhotoObjectModel".equalsIgnoreCase(className)) {
//            return new TypeToken<DevicePhotoObjectModel>(){}.getType();
//        }
//
//        if ("FlagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<FlagModel>(){}.getType();
//        }
//
//        if ("LocationModel".equalsIgnoreCase(className)) {
//            return new TypeToken<LocationModel>(){}.getType();
//        }
//
//        if ("OrganizationModel".equalsIgnoreCase(className)) {
//            return new TypeToken<OrganizationModel>(){}.getType();
//        }
//
//        if ("PatchDeviceModel".equalsIgnoreCase(className)) {
//            return new TypeToken<PatchDeviceModel>(){}.getType();
//        }
//
//        if ("PushMetricEnvelopeModel".equalsIgnoreCase(className)) {
//            return new TypeToken<PushMetricEnvelopeModel>(){}.getType();
//        }
//
//        if ("PushMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<PushMetricModel>(){}.getType();
//        }
//
//        if ("QueryMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<QueryMetricModel>(){}.getType();
//        }
//
//        if ("RadioModel".equalsIgnoreCase(className)) {
//            return new TypeToken<RadioModel>(){}.getType();
//        }
//
//        if ("ResponseCommentModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseCommentModel>(){}.getType();
//        }
//
//        if ("ResponseDeviceModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseDeviceModel>(){}.getType();
//        }
//
//        if ("ResponseDevicePhotosModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseDevicePhotosModel>(){}.getType();
//        }
//
//        if ("ResponseErrorModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseErrorModel>(){}.getType();
//        }
//
//        if ("ResponseFlagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseFlagModel>(){}.getType();
//        }
//
//        if ("ResponseMetadataModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseMetadataModel>(){}.getType();
//        }
//
//        if ("ResponseOrganizationModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseOrganizationModel>(){}.getType();
//        }
//
//        if ("ResponseQueryMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseQueryMetricModel>(){}.getType();
//        }
//
//        if ("ResponseRadioModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseRadioModel>(){}.getType();
//        }
//
//        if ("ResponseStatusModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseStatusModel>(){}.getType();
//        }
//
//        if ("ResponseSummaryModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseSummaryModel>(){}.getType();
//        }
//
//        if ("ResponseTagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseTagModel>(){}.getType();
//        }
//
//        if ("ResponseVenueModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResponseVenueModel>(){}.getType();
//        }
//
//        if ("ResultsQueryMetricModel".equalsIgnoreCase(className)) {
//            return new TypeToken<ResultsQueryMetricModel>(){}.getType();
//        }
//
//        if ("SummaryModel".equalsIgnoreCase(className)) {
//            return new TypeToken<SummaryModel>(){}.getType();
//        }
//
//        if ("TagModel".equalsIgnoreCase(className)) {
//            return new TypeToken<TagModel>(){}.getType();
//        }
//
//        if ("VenueModel".equalsIgnoreCase(className)) {
//            return new TypeToken<VenueModel>(){}.getType();
//        }

        return new TypeToken<Object>(){}.getType();
    }

    public static Object deserialize(String json, String containerType, Class cls) throws ApiException {
        try {
            if ("list".equalsIgnoreCase(containerType) || "array".equalsIgnoreCase(containerType)) {
                return JsonUtil.deserializeToList(json, cls);
            } else if (String.class.equals(cls)) {
                if (json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
                    return json.substring(1, json.length() - 1);
                else
                    return json;
            } else {
                return JsonUtil.deserializeToObject(json, cls);
            }
        } catch (JsonParseException e) {
            throw new ApiException(500, e.getMessage());
        }
    }

    public static String serialize(Object obj) throws ApiException {
        try {
            if (obj != null)
                return JsonUtil.serialize(obj);
            else
                return null;
        } catch (Exception e) {
            throw new ApiException(500, e.getMessage());
        }
    }

};
