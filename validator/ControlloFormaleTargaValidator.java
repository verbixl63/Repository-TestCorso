/*
 * 
 */
package it.dtt.area.veicolo.validator;

import it.dtt.area.common.exception.StringMalformedException;
import it.dtt.area.common.utility.CommonUtilities;
import it.dtt.area.veicolo.bean.EsitoControlloFormaleTarga;
import it.dtt.area.veicolo.dao.TipoVeicoloVEDao;
import it.dtt.area.veicolo.exception.ExceptionMessageVE;
import it.dtt.area.veicolo.factory.VeicoloImmatricolatoVEFactory;
import it.dtt.area.veicolo.interfaccia.ControlloFormaleTarga;
import it.dtt.area.veicolo.service.VeicoloImmatricolatoVEService;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eds.adf.exception.BusinessException;
import com.eds.adf.util.UserMessage;

// TODO: Auto-generated Javadoc
/**
 * RLA11001 – CONTROLLO FORMALE DELLA TARGA.
 *
 * @author Admin
 */
public class ControlloFormaleTargaValidator {
	
	/** The str tipologie veicolo. */
	// evito un accesso al DB inserendo le tipologie in questo array
	public static String[] strTipologieVeicolo = { TipoVeicoloVEDao.TIPO_VEICOLO_A, TipoVeicoloVEDao.TIPO_VEICOLO_M,
			TipoVeicoloVEDao.TIPO_VEICOLO_R, TipoVeicoloVEDao.TIPO_VEICOLO_S, TipoVeicoloVEDao.TIPO_VEICOLO_T,
			TipoVeicoloVEDao.TIPO_VEICOLO_V, TipoVeicoloVEDao.TIPO_VEICOLO_E, TipoVeicoloVEDao.TIPO_VEICOLO_F,
			TipoVeicoloVEDao.TIPO_VEICOLO_G, TipoVeicoloVEDao.TIPO_VEICOLO_H, TipoVeicoloVEDao.TIPO_VEICOLO_P,
			TipoVeicoloVEDao.TIPO_VEICOLO_N, TipoVeicoloVEDao.TIPO_VEICOLO_Z, TipoVeicoloVEDao.TIPO_VEICOLO_U,
			TipoVeicoloVEDao.TIPO_VEICOLO_X, TipoVeicoloVEDao.TIPO_VEICOLO_Y, TipoVeicoloVEDao.TIPO_VEICOLO_C };

	/** The digit pattern 7 PN. */
	// pattern per il controllo
	static Pattern digitPattern7PN = Pattern.compile("[A-Z][A-Z][A-Z][A-Z][0-9][0-9][0-9]");

	/** The digit pattern 7 Z. */
	static Pattern digitPattern7Z = Pattern.compile("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9]");

	/** The digit pattern 7 UXY. */
	static Pattern digitPattern7UXY = Pattern.compile("[A-Z][A-Z][A-Z][0-9][0-9][0-9][A-Z]");

	/** The digit pattern GH. */
	static Pattern digitPatternGH = Pattern
				.compile("[A-Z][A-Z][0-9ABDEFGHLKMNPRSTUVWXYZ][0-9ADEFGHKLMNPRSTUVWXYZ][0-9ADEFGHKLMNPRSTUVWXYZ]");

	/** The digit pattern AMRSTV. */
	static Pattern digitPatternAMRSTV = Pattern
				.compile("[A-Z][A-Z][0-9ABDEFGHLKMNPRSTUVWXYZ][0-9ADEFGHKLMNPRSTUVWXYZ][0-9ADEFGHKLMNPRSTUVWXYZ][0-9][0-9][0-9ADEFGHLMNPRSTVWXYZ]");

	/** The digit pattern E. */
	static Pattern digitPatternE = Pattern
				.compile("[A-Z][A-Z][0-9ABDEFGHLKMNPRSTUVWXYZ][0-9ADEFGHKLMNPRSTUVWXYZ][0-9ADEFGHKLMNPRSTUVWXYZ][0-9ADEFGHLMNPRSTVWXYZ]");

	/** The digit pattern ulteriore 1. */
	static Pattern digitPatternUlteriore1 = Pattern
				.compile("[XYZ][0-9ABCDEFHJKLMNPRTXYZVWRS][0-9ABCDEFHJKLMNPRTXYZVWRS][0-9ABCDEFHJKLMNPRTXYZVWRS][0-9ABCDEFHJKLMNPRTXYZVWRS][0-9ABCDEFHJKLMNPRTXYZVWRS][0-9ABCDEFHJKLMNPRTXYZVWRS]");

	/** The digit pattern ulteriore 2. */
	static Pattern digitPatternUlteriore2 = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9]");

	/** The digit pattern Z. */
	static Pattern digitPatternZ = Pattern.compile("[A-Z][A-Z][0-9][0-9][0-9][0-9][0-9][0-9]");

	/** The digit pattern. */
	static Pattern digitPattern = Pattern.compile("[0-9]");

	/** The digit pattern A. */
	static Pattern digitPatternA = Pattern
				.compile("[ABCDEFGHJKLMNPRSTVWXYZ][ABCDEFGHJKLMNPRSTVWXYZ][0-9][0-9][0-9][ABCDEFGHJKLMNPRSTVWXYZ][ABCDEFGHJKLMNPRSTVWXYZ]");

	/** The digit pattern MR. */
	static Pattern digitPatternMR = Pattern.compile("[ABCDEFGHJKLMNPRSTVWXYZ][ABCDEFGHJKLMNPRSTVWXYZ][0-9][0-9][0-9][0-9][0-9]");
	
	/** The digit pattern R nuove targhe. */
	static Pattern digitPatternRNuoveTarghe = Pattern
			.compile("[ABCDEFGHJKLMNPRSTVWXYZ][ABCDEFGHJKLMNPRSTVWXYZ][0-9][0-9][0-9][ABCDEFGHJKLMNPRSTVWXYZ][ABCDEFGHJKLMNPRSTVWXYZ]");

	/** The digit pattern STV. */
	static Pattern digitPatternSTV = Pattern
				.compile("[ABCDEFGHJKLMNPRSTVWXYZ][ABCDEFGHJKLMNPRSTVWXYZ][0-9][0-9][0-9][ABCDEFGHJKLMNPRSTVWXYZ]");

	/** The digit pattern PN. */
	static Pattern digitPatternPN = Pattern.compile("[A-Z][A-Z][A-Z][0-9][0-9][0-9]");

	/** The digit pattern E 2. */
	static Pattern digitPatternE2 = Pattern.compile("[A-Z][A-Z][0-9][0-9][0-9][0-9]");

	/** The digit pattern FGH. */
	static Pattern digitPatternFGH = Pattern.compile("[A-Z][A-Z][0-9][0-9][0-9]");

	/** The digit pattern ulteriore 3. */
	static Pattern digitPatternUlteriore3 = Pattern.compile("[XYZ][0-9][0-9][0-9][0-9][0-9][0-9]");

	/** The digit pattern ulteriore 4. */
	static Pattern digitPatternUlteriore4 = Pattern
				.compile("[0-9ABCDEFGHJKLMNPRSTVWXYZ][0-9ABCDEFGHJKLMNPRSTVWXYZ][0-9ABCDEFGHJKLMNPRSTVWXYZ][0-9ABCDEFGHJKLMNPRSTVWXYZ][0-9ABCDEFGHJKLMNPRSTVWXYZ][0-9ABCDEFGHJKLMNPRSTVWXYZ][0-9ABCDEFGHJKLMNPRSTVWXYZ]");

	/** The digit pattern C. */
	static Pattern digitPatternC = Pattern
				.compile("[23456789BCDFGHJKLMNPRSTVWXYZ][23456789BCDFGHJKLMNPRSTVWXYZ][23456789BCDFGHJKLMNPRSTVWXYZ][23456789BCDFGHJKLMNPRSTVWXYZ][23456789BCDFGHJKLMNPRSTVWXYZ][23456789BCDFGHJKLMNPRSTVWXYZ]");

	/**
	 * Validate.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param aTarga the a targa
	 * @return the esito controllo formale targa
	 */
	public static EsitoControlloFormaleTarga validate(String codTipoVeicolo, String aTarga) {
		String targaTwoChar = "";
		String targa = aTarga.trim();
		boolean checkProvincia = true;
		boolean verificaPerProvincia = false;
		// 1) presenza dei dati in input
		if (CommonUtilities.isStringNullOrEmpty(codTipoVeicolo) || CommonUtilities.isStringNullOrEmpty(targa)) {
			throw new BusinessException(new UserMessage("Parametri non giunti"));
		}
		// 2) lunghezza stringa nel range 5-8
		if (targa.length() < 5 || targa.length() > 8) {
			throw new StringMalformedException(ExceptionMessageVE.FORMATO_TARGA_NOT_VALID);
		}
		// 3) verifica se il codice veicolo passato corrisponde a quelli
		// esistenti
		chkTipologia(codTipoVeicolo);

		// i primi due caratteri della targa li metto in targaTwoChar
		targaTwoChar = targa.substring(0, 2);

		// 4) CASI particolari

		// se Tipo F
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_F) && targa.length() == 5) {
			if (CommonUtilities.isNumeric(targa.substring(2, 3))) {
				return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
			}
		}
		// se Tipo M,R ci sono delle condizioni per cui non devo fare il
		// controllo della provincia
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_M) || codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_R)) {
			if (targaTwoChar.equals("BT") || targaTwoChar.equals("MB") || targaTwoChar.equals("FM")) {
				// non devo controllare la provincia
				checkProvincia = false;
			}
		}
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_R) && targaTwoChar.equals("AG") && targa.length() == 7) {
			// non devo controllare la provincia
			checkProvincia = false;
		}

		// 5)verificare codice provincia
		if (checkProvincia) {
			// chiamata al DB per verificare se esiste la provincia
			// se esiste verificaPerProvincia=true
			try {
				verificaPerProvincia = chkDBProvincia(targaTwoChar);
			} catch (Exception e) {
				throw new BusinessException(new UserMessage("Errore nella chiamata al DB"));
			}
		}
		EsitoControlloFormaleTarga aEsitoControllo = null;
		// 6)controllo se sono nella situazione che i primi due caratteri della
		// targa
		// sono potenzialmente una provincia
		if (verificaPerProvincia) {
			// se è una provincia controllo x Provincia
			aEsitoControllo = chkTipoProvincia(codTipoVeicolo, targa.trim());
			if (!ControlloFormaleTarga.COD_09.equals(aEsitoControllo.getCodice())) {
				return aEsitoControllo;
			}

		}
		// 7)il controllo per targa solo per tipologia deve avere lunghezza 7
		if (targa.length() < 8) {
			// controllo non x Provincia
			aEsitoControllo = chkTipo(codTipoVeicolo, targa);

			return aEsitoControllo;
		}

		return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
	}

	/**
	 * Metodo che verifica le tipologie con i primi due caratteri della targa che sono una provincia.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkTipoProvincia(String codTipoVeicolo, String targa) {
		// se la targa ha lunghezza 7 ho un tipo di elaborazione altrimenti
		// ne devo fare un'alta
		if (targa.length() == 7) {
			// TIPI PNZUXY
			if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_P) || codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_N)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_Z)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_U)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_X)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_Y))
				return chkPNZUXYProvincia(codTipoVeicolo, targa);
		} else {
			// TIPI AMRSTV EFGH ZUXY
			if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_A) || codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_M)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_R)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_S)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_T)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_V)) {
				return chkAMRSTVProvincia(codTipoVeicolo, targa);
			} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_E)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_F)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_G)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_H)) {
				return chkEFGHProvincia(codTipoVeicolo, targa);
			} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_Z)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_U)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_X)
						|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_Y)) {
				return chkZUXYProvincia(codTipoVeicolo, targa);
			} else {
				throw new BusinessException(new UserMessage(ExceptionMessageVE.CODICE_TIPO_VEICOLO_NOT_VALID));
			}
		}
		return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
	}

	/**
	 * Controllo i tipi PNZUXY con targa di lunghezza 7 e primi due caratteri della targa che corrispondono a una provincia.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkPNZUXYProvincia(String codTipoVeicolo, String targa) {
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_P) || codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_N)) {
			return chk7PNProvincia(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_Z)) {
			return chk7ZProvincia(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_X)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_Y)) {
			return chk7UXYProvincia(targa);
		} else {
			throw new BusinessException(new UserMessage(ExceptionMessageVE.CODICE_TIPO_VEICOLO_NOT_VALID));
		}

	}

	/**
	 * Chk 7 PN provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chk7PNProvincia(String targa) {
		Matcher digitMatcher = digitPattern7PN.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);

		} else if (targa.length() == 7 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_02, ControlloFormaleTarga.DESCRIZIONE_COD_02);
	}

	/**
	 * Chk 7 Z provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chk7ZProvincia(String targa) {
		Matcher digitMatcher = digitPattern7Z.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 7 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_02, ControlloFormaleTarga.DESCRIZIONE_COD_02);
	}

	/**
	 * Chk 7 UXY provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chk7UXYProvincia(String targa) {
		Matcher digitMatcher = digitPattern7UXY.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 7 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_02, ControlloFormaleTarga.DESCRIZIONE_COD_02);
	}

	/**
	 * Controllo i tipi AMRSTV con targa di lunghezza variabile e primi due caratteri della targa che corrispondono a una
	 * provincia.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkAMRSTVProvincia(String codTipoVeicolo, String targa) {
		Matcher digitMatcher = digitPatternAMRSTV.matcher(targa);
		boolean chk = digitMatcher.find();
		if (targa.length() != 8) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 8 && chk) {
			// almeno un carattere alfabetico dalla posizione 3 a 8
			for (int i = 2; i < 8; i++) {
				String appCarattere = String.valueOf(targa.charAt(i));
				digitPattern.matcher(appCarattere);
				if (digitMatcher.find())
					return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
			}

			return esito(ControlloFormaleTarga.COD_02, ControlloFormaleTarga.DESCRIZIONE_COD_02);
		}
		return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
	}

	/**
	 * Controllo i tipi EFGH con targa di lunghezza variabile e primi due caratteri della targa che corrispondono a una provincia.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkEFGHProvincia(String codTipoVeicolo, String targa) {
		boolean ulterioreChk = true;
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_E)) {
			ulterioreChk = chkEProvincia(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_F)) {
			ulterioreChk = chkFProvincia(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_G)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_H)) {
			ulterioreChk = chkGHProvincia(targa);
		}
		// se il controllo non ha dato esito positivo dobbiamo fare un ulteriore
		// controllo
		// per verificare se e' una TARGA PERSONALIZZATA
		if (!ulterioreChk) {
			return chkUlterioreEFGHProvincia(targa);
		}
		return esito(ControlloFormaleTarga.COD_02, ControlloFormaleTarga.DESCRIZIONE_COD_02);
	}

	/**
	 * Chk E provincia.
	 *
	 * @param targa the targa
	 * @return true, if successful
	 */
	private static boolean chkEProvincia(String targa) {
		Matcher digitMatcher = digitPatternE.matcher(targa);
		if (targa.length() != 6) {
			return false;
		} else if (targa.length() == 6 && !digitMatcher.find()) {
			return false;
		}
		return true;
	}

	/**
	 * Chk F provincia.
	 *
	 * @param targa the targa
	 * @return true, if successful
	 */
	private static boolean chkFProvincia(String targa) {
		if (targa.length() != 5) {
			return false;
		} else if (targa.length() == 5) {
			for (int i = 2; i < 5; i++) {
				String appCarattere = String.valueOf(targa.charAt(i));
				Matcher digitMatcher = digitPattern.matcher(appCarattere);
				if (digitMatcher.find())
					return true;
			}
		}
		return true;
	}

	/**
	 * Chk GH provincia.
	 *
	 * @param targa the targa
	 * @return true, if successful
	 */
	private static boolean chkGHProvincia(String targa) {
		Matcher digitMatcher = digitPatternGH.matcher(targa);
		if (targa.length() != 5) {
			return false;
		} else if (targa.length() == 5 && !digitMatcher.find()) {
			return false;
		}
		// almeno un carattere alfabetico
		for (int i = 2; i < 5; i++) {
			String appCarattere = String.valueOf(targa.charAt(i));
			digitMatcher = digitPattern.matcher(appCarattere);
			if (digitMatcher.find())
				return true;
		}
		return true;
	}

	/**
	 * Chk ulteriore EFGH provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkUlterioreEFGHProvincia(String targa) {
		Matcher digitMatcher = digitPatternUlteriore1.matcher(targa);
		Matcher digitMatcher2 = digitPatternUlteriore2.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 7 && (digitMatcher.find() || digitMatcher2.find())) {
			// situazione di targa personalizzata
			return esito(ControlloFormaleTarga.COD_03, ControlloFormaleTarga.DESCRIZIONE_COD_03);
		}
		return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);

	}

	/**
	 * Controllo i tipi ZUXY con targa di lunghezza variabile e primi due caratteri della targa che corrispondono a una provincia.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkZUXYProvincia(String codTipoVeicolo, String targa) {
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_E)) {
			return chkZProvincia(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_U)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_X)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_Y)) {
			return chkUXYProvincia(targa);
		} else {
			throw new BusinessException(new UserMessage(ExceptionMessageVE.CODICE_TIPO_VEICOLO_NOT_VALID));
		}
	}

	/**
	 * Chk Z provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkZProvincia(String targa) {
		Matcher digitMatcher = digitPatternZ.matcher(targa);
		if (targa.length() != 8) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 8 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_02, ControlloFormaleTarga.DESCRIZIONE_COD_02);
	}

	/**
	 * Chk UXY provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkUXYProvincia(String targa) {
		if (targa.length() < 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_02, ControlloFormaleTarga.DESCRIZIONE_COD_02);
	}

	/**
	 * Metodo che verifica le tipologie con i primi due caratteri che non sono una provincia.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkTipo(String codTipoVeicolo, String targa) {
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_A)) {
			return chkA(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_C)) {
			return chkC(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_M)) {
			return chkMR(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_R) && targa.startsWith("X")) {
			return chkNuoveTargheRimorchi(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_R)) {
			return chkMR(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_S)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_T)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_V)) {
			return chkSTV(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_P)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_N)) {
			return chkPN(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_E)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_F)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_G)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_H)) {
			return chkEFGH(codTipoVeicolo, targa);
		} else {
			throw new BusinessException(new UserMessage(ExceptionMessageVE.CODICE_TIPO_VEICOLO_NOT_VALID));
		}

	}

	/**
	 * Controllo il tipo A con targa di lunghezza 7 e primi due caratteri della targa che non corrispondono a una provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkA(String targa) {
		Matcher digitMatcher = digitPatternA.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 7 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
	}

	/**
	 * Controllo i tipi MR con targa di lunghezza 7 e primi due caratteri della targa che non corrispondono a una provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkMR(String targa) {
		Matcher digitMatcher = digitPatternMR.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 7 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
	}

	/**
	 * Controllo i tipi MR con targa di lunghezza 7 e primi due caratteri della targa che non corrispondono a una provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkNuoveTargheRimorchi(String targa) {
		Matcher digitMatcher = digitPatternRNuoveTarghe.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 7 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
	}

	/**
	 * Controllo i tipi STV con targa di lunghezza 6 e primi due caratteri della targa che non corrispondono a una provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkSTV(String targa) {
		Matcher digitMatcher = digitPatternSTV.matcher(targa);
		if (targa.length() != 6) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 6 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
	}

	/**
	 * Controllo i tipi PN con targa di lunghezza 6 e primi due caratteri della targa che non corrispondono a una provincia.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkPN(String targa) {
		Matcher digitMatcher = digitPatternPN.matcher(targa);
		if (targa.length() != 6) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 6 && !digitMatcher.find()) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		}
		return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
	}

	/**
	 * Controllo i tipi EFGH con targa di lunghezza variabile e primi due caratteri della targa che non corrispondono a una
	 * provincia.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkEFGH(String codTipoVeicolo, String targa) {
		boolean ulterioreChk = true;
		if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_E)) {
			ulterioreChk = chkE(targa);
		} else if (codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_F)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_G)
					|| codTipoVeicolo.equals(TipoVeicoloVEDao.TIPO_VEICOLO_H)) {
			ulterioreChk = chkFGH(targa);
		}
		// se il controllo non ha dato esito positivo dobbiamo fare un ulteriore
		// controllo
		// per verificare se e' una TARGA PERSONALIZZATA
		if (!ulterioreChk) {
			return chkUlterioreEFGH(targa);
		}
		return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
	}

	/**
	 * Chk E.
	 *
	 * @param targa the targa
	 * @return true, if successful
	 */
	private static boolean chkE(String targa) {
		Matcher digitMatcher = digitPatternE2.matcher(targa);
		if (targa.length() != 6) {
			return false;
		} else if (targa.length() == 6 && !digitMatcher.find()) {
			return false;
		}
		return true;
	}

	/**
	 * Chk FGH.
	 *
	 * @param targa the targa
	 * @return true, if successful
	 */
	private static boolean chkFGH(String targa) {
		Matcher digitMatcher = digitPatternFGH.matcher(targa);
		if (targa.length() != 5) {
			return false;
		} else if (targa.length() == 5 && !digitMatcher.find()) {
			return false;
		}
		return true;
	}

	/**
	 * Chk ulteriore EFGH.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkUlterioreEFGH(String targa) {
		Matcher digitMatcher = digitPatternUlteriore3.matcher(targa);
		Matcher digitMatcher2 = digitPatternUlteriore4.matcher(targa);
		if (targa.length() != 7) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 7 && (digitMatcher.find() || digitMatcher2.find())) {
			return esito(ControlloFormaleTarga.COD_03, ControlloFormaleTarga.DESCRIZIONE_COD_03);

		}
		return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);

	}

	/**
	 * Chk C.
	 *
	 * @param targa the targa
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga chkC(String targa) {
		Matcher digitMatcher = digitPatternC.matcher(targa);
		if (targa.length() != 6) {
			return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);
		} else if (targa.length() == 6 && (digitMatcher.find())) {
			return esito(ControlloFormaleTarga.COD_01, ControlloFormaleTarga.DESCRIZIONE_COD_01);
		}
		return esito(ControlloFormaleTarga.COD_09, ControlloFormaleTarga.DESCRIZIONE_COD_09);

	}

	/**
	 * Metodo che verifica nella tabella delle provincie se la sigla passata corrisponde a una provincia.
	 *
	 * @param siglaProvincia the sigla provincia
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	private static boolean chkDBProvincia(String siglaProvincia) throws SQLException {
		boolean isProvincia = false;

		VeicoloImmatricolatoVEService veicoloService = VeicoloImmatricolatoVEFactory.getService();
		isProvincia = veicoloService.checkSiglaAutomobilisticaTarga(siglaProvincia);

		return isProvincia;
	}

	/**
	 * Metodo che popola l'esito con il codice e la descrizione passata.
	 *
	 * @param codice the codice
	 * @param descrizioneCodice the descrizione codice
	 * @return the esito controllo formale targa
	 */
	private static EsitoControlloFormaleTarga esito(String codice, String descrizioneCodice) {
		EsitoControlloFormaleTarga esitoContollo = new EsitoControlloFormaleTarga();
		esitoContollo.setCodice(codice);
		esitoContollo.setDescrizione(descrizioneCodice);
		return esitoContollo;
	}

	/**
	 * Controlla se la tipologia veicolo è corretta.
	 *
	 * @param codTipoVeicolo the cod tipo veicolo
	 */
	public static void chkTipologia(String codTipoVeicolo) {
		String appCodTipoVeicolo = "";
		// verifica se il codice veicolo passato corrisponde a quelli
		// esistenti
		for (String cod : strTipologieVeicolo) {
			if (cod.equals(codTipoVeicolo)) {
				appCodTipoVeicolo = codTipoVeicolo;
				break;
			}
		}

		if ("".equals(appCodTipoVeicolo)) {
			throw new BusinessException(new UserMessage(ExceptionMessageVE.CODICE_TIPO_VEICOLO_NOT_VALID));
		}
	}

}
