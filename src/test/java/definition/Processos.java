package definition;

import groovy.json.internal.LazyMap;
import support.RESTSupport;

public class Processos {

    private  static  LazyMap camposJson = new LazyMap();
    private  static  final String URL = "http://agapito-server.herokuapp.com/processos";
    private static String _id;

    public static void limparCampos() {
        camposJson.clear();
    }

    public static void preencherCampo(String campo, String valor) {
        camposJson.put(campo, valor);
    }

    public static String getEndPoint() {
       return  URL;
    }

    public static LazyMap getCompos() {
        return  camposJson;
    }

    public static void setId(String id) {
        _id = id;
    }

    public static String getId() {
        return _id;
    }

    public static String recuperarCampo(String campo) {
        return RESTSupport.key(campo).toString();
    }

    public static String getLastUser() {
        return _id;
    }

    public static void setLastUser(String _id) {
        Processos._id = _id;
    }

    public static LazyMap getFields() {
        return camposJson;
    }

    public static void addFields(String field, String value) {
        camposJson.put(field, value);
    }
}
