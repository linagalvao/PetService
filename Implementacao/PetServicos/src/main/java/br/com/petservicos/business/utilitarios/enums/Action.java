/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petservicos.business.utilitarios.enums;

/**
 *
 * @author Lina
 */
public enum Action {
    DV,//DON'T VALIDATION
    I,//INSERT
    D,
    U,
    S,
    I_D,
    I_U,
    I_S,
    D_U,
    D_S,
    U_S,
    I_D_U,
    I_D_S,
    I_U_S,
    D_U_S;
    public static boolean validationSelect(Action actionValidation) {
        if (null != actionValidation) switch (actionValidation) {
            case S:
                return true;
            case I_S:
                return true;
            case D_S:
                return true;
            case U_S:
                return true;
            case I_D_S:
                return true;
            case D_U_S:
                return true;
            case I_U_S:
                return true;
            default:
                break;
        }
        return false;
    }
    public static boolean validationUpdate(Action actionValidation) {
        if (null != actionValidation) switch (actionValidation) {
            case U:
                return true;
            case I_U:
                return true;
            case D_U:
                return true;
            case U_S:
                return true;
            case I_D_U:
                return true;
            case D_U_S:
                return true;
            case I_U_S:
                return true;
            default:
                break;
        }
        return false;
    }

    public static boolean validationInsert(Action actionValidation) {
        if (null != actionValidation) switch (actionValidation) {
            case I:
                return true;
            case I_D:
                return true;
            case I_D_S:
                return true;
            case I_D_U:
                return true;
            case I_S:
                return true;
            case I_U:
                return true;
            case I_U_S:
                return true;
            default:
                break;
        }
        return false;
    }
    public static boolean validationDelete(Action actionValidation) {
        if (null != actionValidation) switch (actionValidation) {
            case D:
                return true;
            case I_D:
                return true;
            case I_D_S:
                return true;
            case I_D_U:
                return true;
            case D_S:
                return true;
            case D_U:
                return true;
            case D_U_S:
                return true;
            default:
                break;
        }
        return false;
    }
}
