/**************************************************************************
*
* Copyright 2017 (C) HP
*
* Created on  : 6-apr-2017
* Author      : HP ES
* Project Name: AreaVeicolo-core 
* Package     : it.dtt.area.veicolo.validator.tipoveicolo
* File Name   : TipologiaVeicoloConstants.java
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
package it.dtt.area.veicolo.validator.tipoveicolo;

// TODO: Auto-generated Javadoc
/**
 * The Class TipologiaVeicoloConstants.
 */
class TipologiaVeicoloConstants {
	
	/** The Constant ALFABETO_X. */
	static final String ALFABETO_X = "X";
	
	/** The Constant ALFABETO_Y. */
	static final String ALFABETO_Y = "Y";
	
	/** The Constant ALFABETO_CD. */
	static final String ALFABETO_CD = "CD";
	
	/** The Constant ALFABETO_CC. */
	static final String ALFABETO_CC = "CC";
	
	/** The Constant ALFABETO_EE. */
	static final String ALFABETO_EE = "EE";
	
	/** The Constant ALFABETO. */
	static final String ALFABETO = "[a-zA-Z]+";
	
	/** The Constant ALFANUMERICO. */
	static final String ALFANUMERICO = "\\w+";
	
	/** The Constant ALFABETO_NOT_IOQU. */
	static final String ALFABETO_NOT_IOQU = "[a-zA-Z&&[^IOQU]]+";
	
	/** The Constant ALFANUMERICO_NOT_IOQU. */
	static final String ALFANUMERICO_NOT_IOQU = "[\\w&&[^IOQU]]+";
	
	/** The Constant ALFANUMERICO_CICLOMOTORE. */
	static final String ALFANUMERICO_CICLOMOTORE = "[\\w&&[^aAeEiIoOuUqQ01]]+";
	
	/** The Constant ALFANUMERICO_NOT_CIJOQ. */
	static final String ALFANUMERICO_NOT_CIJOQ = "[\\w&&[^cCiIjJoOqQ]]+";
	
	/** The Constant ALFANUMERICO_NOT_BCIJOQ. */
	static final String ALFANUMERICO_NOT_BCIJOQ = "[\\w&&[^bBcCiIjJoOqQ]]+";
	
	/** The Constant ALFANUMERICO_NOT_BCIJKOQU. */
	static final String ALFANUMERICO_NOT_BCIJKOQU = "[\\w&&[^bBcCiIjJkKoOqQuU]]+";
	
	/** The Constant ALFABETO_PRESENTE_ALMENO_UNO. */
	static final String ALFABETO_PRESENTE_ALMENO_UNO = "\\w*[a-zA-z]+\\w*";
	
	/** The Constant NUMERICO. */
	static final String NUMERICO = "[\\d]+";
}
