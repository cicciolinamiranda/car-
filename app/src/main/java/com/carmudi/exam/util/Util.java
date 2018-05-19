package com.carmudi.exam.util;

/**
 * Created by cicciolina on 5/18/18.
 */

public class Util {

    private static Util instance;

    private Util() {}

    public static Util getInstance() {

        if (instance == null) {
            instance = new Util();
        }


        return instance;
    }

    public  String withSuffix(double count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format("%.1f %c",
                count / Math.pow(1000, exp),
                "kMGTPE".charAt(exp-1));
    }

    public String truncateNumber(double doubleNumber, boolean isOneLetterOnly) {
        float million = 1000000L;
        float billion = 1000000000L;
        float trillion = 1000000000000L;
        float number = Math.round(doubleNumber);
        if ((number >= million) && (number < billion) && isOneLetterOnly) {
            float fraction = calculateFraction(number, million);
            return Float.toString(fraction) + "M";
        }
        else if ((number >= million) && (number < billion) && !isOneLetterOnly) {
            float fraction = calculateFraction(number, million);
            return Float.toString(fraction) + "mil";
        }
        else if ((number >= billion) && (number < trillion) && isOneLetterOnly) {
            float fraction = calculateFraction(number, billion);
            return Float.toString(fraction) + "B";
        }
        else if ((number >= billion) && (number < trillion) && !isOneLetterOnly) {
            float fraction = calculateFraction(number, billion);
            return Float.toString(fraction) + "bil";
        }

        return Float.toString(number);
    }

    public float calculateFraction(double number, double divisor) {
        double truncate = (number * 10L + (divisor / 2L)) / divisor;
        float fraction = (float) truncate * 0.10F;
        return fraction;
    }

    public static final String result = "{\n" +
            "success: true,\n" +
            "messages: {\n" +
            "success: [\n" +
            "\"SEARCH_QUERY_SUCCESS\"\n" +
            "]\n" +
            "},\n" +
            "session: {\n" +
            "id: \"sqhadlnfe1ckldav0h08ktthu4\",\n" +
            "expire: \"\",\n" +
            "YII_CSRF_TOKEN: \"a1e633ad538ae6dce13d962cd26f35b4330136e6\"\n" +
            "},\n" +
            "metadata: {\n" +
            "product_count: \"32654\",\n" +
            "results: [\n" +
            "{\n" +
            "data: {\n" +
            "fk_country: \"101\",\n" +
            "status: \"active\",\n" +
            "attribute_set_name: \"Mobil\",\n" +
            "attribute_set_name_local: \"Mobil\",\n" +
            "approved: \"1\",\n" +
            "status_supplier_config: \"active\",\n" +
            "activated_at: \"2017-06-13 18:33:09\",\n" +
            "listing_start: \"2017-06-20 04:03:14\",\n" +
            "listing_end: \"2018-06-04 16:02:52\",\n" +
            "fk_vertical: \"1\",\n" +
            "fk_catalog_brand: \"92\",\n" +
            "fk_catalog_brand_model: \"3933\",\n" +
            "brand_model_edition: \"TERBATAS SAMPAI JULI 2017\",\n" +
            "listing_type: \"Classifieds\",\n" +
            "listing_country: \"Indonesia\",\n" +
            "listing_area: \"\",\n" +
            "condition: \"Baru\",\n" +
            "condition_position: \"1\",\n" +
            "condition_id: \"1\",\n" +
            "color_family_position: \"5\",\n" +
            "color_family_id: \"11\",\n" +
            "doors_position: \"1\",\n" +
            "doors_id: \"4\",\n" +
            "power: \"97\",\n" +
            "drive_type_position: \"1\",\n" +
            "drive_type_id: \"1\",\n" +
            "interior: \"Airbag Sopir|Airbag Samping|AC|Tempat Minum|Radio|USB\",\n" +
            "exterior: \"Velg Racing|Roof rack|Lampu Kabut\",\n" +
            "equipment: \"Alarm System|Power Steering|Anti-Lock Braking System|Keyless Entry|Engine immobilizer|Power door locks|Power Windows|Electric mirrors\",\n" +
            "warranty_type_position: \"1\",\n" +
            "warranty_type_id: \"3\",\n" +
            "warranty_years_position: \"1\",\n" +
            "warranty_years_id: \"11\",\n" +
            "price_conditions_position: \"1\",\n" +
            "price_conditions_id: \"2\",\n" +
            "premium_listing: \"1\",\n" +
            "alternate_sku: \"C-ID-01020037\",\n" +
            "original_name: \"2017 Suzuki Ertiga\",\n" +
            "root_category: \"29\",\n" +
            "agency_logo: \"\",\n" +
            "new-product: false,\n" +
            "url: \"http://www.carmudi.co.id/api/2017-Ertiga-1020037.html\",\n" +
            "id: \"1020037\",\n" +
            "location_latitude: \"-6.262955900000000\",\n" +
            "location_longitude: \"106.760262800000000\",\n" +
            "google_formatted_address: \"Gg. Buntu, Bintaro, Pesanggrahan, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12330, Indonesia\",\n" +
            "google_place_id: \"EmtKYWxhbiBCaW50YXJvIFBlcm1haSBJViBHYW5nIEJ1bnR1LCBCaW50YXJvLCBLb3RhIEpha2FydGEgU2VsYXRhbiwgRGFlcmFoIEtodXN1cyBJYnVrb3RhIEpha2FydGEsIEluZG9uZXNpYQ\",\n" +
            "fk_customer_address: \"305096\",\n" +
            "listing_region: \"Jakarta\",\n" +
            "listing_city: \"Kota Jakarta Selatan\",\n" +
            "agency_address: \"\",\n" +
            "agency_city: \"Kota Jakarta Selatan\",\n" +
            "fk_country_region: \"13\",\n" +
            "fk_country_region_city: \"5693\",\n" +
            "fk_country_region_city_area: \"\",\n" +
            "show_listing_address: \"0\",\n" +
            "item_contact_name: \"SAHABAT SUZUKI JAKARTA\",\n" +
            "item_contact_email: \"aries@sunmotor.com\",\n" +
            "item_contact_mobile: \"081318587276\",\n" +
            "item_contact_homephone: \"081318587276\",\n" +
            "agency_name: \"SAHABAT SUZUKI JAKARTA\",\n" +
            "product_owner_url_key: \"sahabat-suzuki-jakarta\",\n" +
            "product_owner: \"247951\",\n" +
            "fk_customer: \"247951\",\n" +
            "is_agent: \"1\",\n" +
            "seller_is_trusted: \"1\",\n" +
            "show_officephone: \"\",\n" +
            "show_homephone: \"\",\n" +
            "show_mobile: \"1\",\n" +
            "sku: \"SU092CAAALV2DINTCARID\",\n" +
            "id_catalog_config: \"1020037\",\n" +
            "attribute_set_id: \"1\",\n" +
            "original_price_currency: \"1\",\n" +
            "is_certified: 0,\n" +
            "name: \"2017 Suzuki Ertiga GL SUPER DAHSYAT TDP HANYA Rp 9 Jt-an /HADIAH TOUR BERSAMA KELUARGA KE BALI\",\n" +
            "description: \"Produk berkualitas SUZUKI ,dengan harga bersahabat siap menjamin keamanan dan kenyamanan anda berkendara. Dilengkapi dengan semua sistem keamanan aktif dan pasif. Dahsyat TDP hanya Rp 9Jt an langsung bawa pulang\",\n" +
            "urlkey_details: \"2017-suzuki-ertiga-gl-super-dahsyat-tdp-hanya-rp-9-jt-an-hadiah-tour-bersama-keluarga-ke-bali-1020037.html\",\n" +
            "price_not_available: \"0\",\n" +
            "price: \"202500000.00\",\n" +
            "original_price: \"202500000.00\",\n" +
            "brand: \"Suzuki\",\n" +
            "brand_model: \"Ertiga\",\n" +
            "top_position: \"1\",\n" +
            "mileage_not_available: \"1\",\n" +
            "mileage: \"0\",\n" +
            "config_id: \"1020037\",\n" +
            "rejected_comment: \"\",\n" +
            "transmission: \"Manual\",\n" +
            "transmission_position: \"1\",\n" +
            "transmission_id: \"1\",\n" +
            "fuel: \"Bensin\",\n" +
            "fuel_position: \"1\",\n" +
            "fuel_id: \"1\",\n" +
            "simples: {\n" +
            "SU092CAAALV2DINTCARID: {\n" +
            "meta: {\n" +
            "price_not_available: \"0\",\n" +
            "original_price_currency: \"IDR\",\n" +
            "price: \"202500000.00\",\n" +
            "original_price: \"202500000.00\",\n" +
            "price_conditions_position: \"1\",\n" +
            "price_conditions_id: \"2\",\n" +
            "sku: \"SU092CAAALV2DINTCARID\"\n" +
            "},\n" +
            "attributes: {\n" +
            "price_conditions: \"Siap pakai\"\n" +
            "}\n" +
            "}\n" +
            "},\n" +
            "attributes: {\n" +
            "description: \"Produk berkualitas SUZUKI ,dengan harga bersahabat siap menjamin keamanan dan kenyamanan anda berkendara. Dilengkapi dengan semua sistem keamanan aktif dan pasif. Dahsyat TDP hanya Rp 9Jt an langsung bawa pulang\",\n" +
            "year_built: \"2017\",\n" +
            "engine: \"1500\",\n" +
            "price_conditions: \"Siap pakai\",\n" +
            "price_conditions_id: \"2\",\n" +
            "color_family: \"Putih\",\n" +
            "seats: \"0\",\n" +
            "doors: \"5\",\n" +
            "drive_type: \"Front wheel drive\",\n" +
            "warranty_type: \"\",\n" +
            "warranty_years: \"\",\n" +
            "warranty_kms: \"\",\n" +
            "all: {\n" +
            "details: [\n" +
            "{\n" +
            "name: \"description\",\n" +
            "label: \"Deskripsi (Bahasa)\",\n" +
            "label_en: \"Description (Bahasa)\",\n" +
            "value: \"Produk berkualitas SUZUKI ,dengan harga bersahabat siap menjamin keamanan dan kenyamanan anda berkendara. Dilengkapi dengan semua sistem keamanan aktif dan pasif. Dahsyat TDP hanya Rp 9Jt an langsung bawa pulang\"\n" +
            "},\n" +
            "{\n" +
            "name: \"year_built\",\n" +
            "label: \"Pembuatan (Tahun)\",\n" +
            "label_en: \"Build (Year)\",\n" +
            "value: \"2017\"\n" +
            "},\n" +
            "{\n" +
            "name: \"engine\",\n" +
            "label: \"Mesin\",\n" +
            "label_en: \"Engine\",\n" +
            "value: \"1500\"\n" +
            "},\n" +
            "{\n" +
            "name: \"price_conditions\",\n" +
            "label: \"Price Conditions\",\n" +
            "label_en: \"Price Conditions\",\n" +
            "value: \"Siap pakai\"\n" +
            "},\n" +
            "{\n" +
            "name: \"color_family\",\n" +
            "label: \"Golongan Warna\",\n" +
            "label_en: \"Color Family\",\n" +
            "value: \"Putih\"\n" +
            "},\n" +
            "{\n" +
            "name: \"seats\",\n" +
            "label: \"Tempat duduk\",\n" +
            "label_en: \"Seats\",\n" +
            "value: \"0\"\n" +
            "},\n" +
            "{\n" +
            "name: \"doors\",\n" +
            "label: \"Pintu\",\n" +
            "label_en: \"Doors\",\n" +
            "value: \"5\"\n" +
            "},\n" +
            "{\n" +
            "name: \"drive_type\",\n" +
            "label: \"Tipe Kemudi\",\n" +
            "label_en: \"Drive Type\",\n" +
            "value: \"Front wheel drive\"\n" +
            "},\n" +
            "{\n" +
            "name: \"warranty_type\",\n" +
            "label: \"Warranty type\",\n" +
            "label_en: \"Warranty type\",\n" +
            "value: \"\"\n" +
            "},\n" +
            "{\n" +
            "name: \"warranty_years\",\n" +
            "label: \"Warranty years\",\n" +
            "label_en: \"Warranty years\",\n" +
            "value: \"\"\n" +
            "},\n" +
            "{\n" +
            "name: \"warranty_kms\",\n" +
            "label: \"Warranty in kilometres\",\n" +
            "label_en: \"Warranty in kilometres\",\n" +
            "value: \"\"\n" +
            "}\n" +
            "],\n" +
            "optional: [\n" +
            "{\n" +
            "name: \"interior\",\n" +
            "label: \"Interior\",\n" +
            "label_en: \"Interior\",\n" +
            "options: [\n" +
            "\"Airbag Sopir\",\n" +
            "\"Airbag Samping\",\n" +
            "\"AC\",\n" +
            "\"Tempat Minum\",\n" +
            "\"Radio\",\n" +
            "\"USB\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "name: \"exterior\",\n" +
            "label: \"Eksterior\",\n" +
            "label_en: \"Exterior\",\n" +
            "options: [\n" +
            "\"Velg Racing\",\n" +
            "\"Roof rack\",\n" +
            "\"Lampu Kabut\"\n" +
            "]\n" +
            "},\n" +
            "{\n" +
            "name: \"equipment\",\n" +
            "label: \"Perlengkapan\",\n" +
            "label_en: \"Equipment\",\n" +
            "options: [\n" +
            "\"Alarm System\",\n" +
            "\"Power Steering\",\n" +
            "\"Anti-Lock Braking System\",\n" +
            "\"Keyless Entry\",\n" +
            "\"Engine immobilizer\",\n" +
            "\"Power door locks\",\n" +
            "\"Power Windows\",\n" +
            "\"Electric mirrors\"\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "}\n" +
            "},\n" +
            "id: \"1020037\",\n" +
            "images: [\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/5vTY78NAIKx7kPfEz9SPv0gbRo4=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d33167da4.90032234-catalog.jpg\"\n" +
            "},\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/bbBCNf1NPiS4MJe3aNAbm49stDY=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d2e5daaa1.71905188-catalog.jpg\"\n" +
            "},\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/OXcU_JvWiT6nL-YKS_LgCC3yAEU=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d158db9a1.82698407-catalog.jpg\"\n" +
            "},\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/nRKcYUebUXQnRemTUGla74MK5HE=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d19e44ad8.41749803-catalog.jpg\"\n" +
            "},\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/iBHcLdlX0cc6_i-lqcW8kCVjkAM=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d1e069fb9.52941670-catalog.jpg\"\n" +
            "},\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/QAASGxbjciqsvchCqQXHJdZgWk4=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d21c61048.98251629-catalog.jpg\"\n" +
            "},\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/vuyARH3oFCvwo-T5bdkz9nXl0p4=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d25db0a82.83528464-catalog.jpg\"\n" +
            "},\n" +
            "{\n" +
            "url: \"http://static.carmudi.co.id/dZVgpLuJW24l6gW2Z15iydZp6OQ=/filters:watermark(http://static.carmudi.co.id/z1JzNSglXy6TpbQnTIRW41vjx_4=/WATERMARK/carmudi.png,0,0,0)/listing_images/ID/upload_593f7d29f0b5f6.70014081-catalog.jpg\"\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "]\n" +
            "}\n" +
            "}";
}
