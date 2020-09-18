/**************************************************************************
*
* Copyright 2017 (C) HP
*
* Created on  : 6-apr-2017
* Author      : HP ES
* Project Name: AreaVeicolo-core 
* Package     : it.dtt.area.veicolo.validator
* File Name   : TelaioValidator.java
*
*-----------------------------------------------------------------------------
* Revision History (Release 1.0)
*-----------------------------------------------------------------------------
* VERSION     AUTHOR/      DESCRIPTION OF CHANGE
* OLD/NEW     DATE                RFC NO
*-----------------------------------------------------------------------------
*
*
***************************************************************************/
package it.dtt.area.veicolo.validator;

import it.dtt.area.common.exception.StringMalformedException;
import it.dtt.area.veicolo.exception.ExceptionMessageVE;

// TODO: Auto-generated Javadoc
/**
 * The Class TelaioValidator.
 */
public class TelaioValidator {

	/**
	 * Validate numero telaio.
	 *
	 * @param numeroTelaio the numero telaio
	 */
	public static void validateNumeroTelaio(String numeroTelaio) {  

		String telaio = numeroTelaio.trim();

		if (telaio.length() > 20) {
			throw new StringMalformedException(
					ExceptionMessageVE.LUNGHEZZA_TELAIO_NOT_VALID);
		}
	}

	/**
	 * Normalizzazione telaio.
	 *
	 * @param numeroTelaio the numero telaio
	 * @return the string
	 */
	public static String normalizzazioneTelaio(String numeroTelaio) {
		String telaioNormalizzato = "";
		for (int i = 0; i < numeroTelaio.length(); i++) {
			if (Character.isLetterOrDigit(numeroTelaio.charAt(i))) {
				telaioNormalizzato = telaioNormalizzato
						+ numeroTelaio.charAt(i);
			}
		}
		return telaioNormalizzato;
	}
}
