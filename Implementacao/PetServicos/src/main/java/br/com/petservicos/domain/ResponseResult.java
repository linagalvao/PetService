package br.com.petservicos.domain;

import java.io.Serializable;

/**
 * Class that represents the message header sent by the server.
 * 
 * @author Lina
 *
 */
public class ResponseResult implements Serializable {
	private static final long serialVersionUID = -4544022656152851241L;

	private final String version;
	private final String author;
	private final String email;

	/**
	 * Constructor a header object with follow params.
	 * 
	 * @param version
	 * @param author
	 * @param email
	 */
	public ResponseResult(String version, String author, String email) {
		this.version = version;
		this.author = author;
		this.email = email;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Header [version=" + version + ", author=" + author + ", email=" + email + "]";
	}

}