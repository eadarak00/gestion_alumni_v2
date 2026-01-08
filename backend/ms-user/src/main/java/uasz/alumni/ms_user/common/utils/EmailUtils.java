package uasz.alumni.ms_user.common.utils;


public class EmailUtils {

    public static String sujetValidationInscription() {
        return "Validation de votre compte Utilisateur";
    }

    public static String corpsValidationInscriptionHTML(String nom, String code) {
        return String.format(
                """
                                       <!DOCTYPE html>
                        <html>
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <style>
                                body {
                                    font-family: 'Segoe UI', Arial, sans-serif;
                                    line-height: 1.7;
                                    color: #374151;
                                    background-color: #ffffff;
                                    margin: 0;
                                    padding: 40px 20px;
                                }
                                .container {
                                    max-width: 580px;
                                    margin: 0 auto;
                                    background-color: #ffffff;
                                }
                                .header {
                                    padding: 0 0 30px 0;
                                    border-bottom: 3px solid #1B9A76;
                                }
                                .header-content {
                                    display: flex;
                                    align-items: center;
                                }
                                .logo-text {
                                    font-size: 22px;
                                    font-weight: 700;
                                    color: #1B9A76;
                                }
                                .logo-sub {
                                    font-size: 11px;
                                    color: #6b7280;
                                    text-transform: uppercase;
                                    letter-spacing: 1px;
                                    margin-top: 2px;
                                }
                                .content {
                                    padding: 35px 0;
                                }
                                .greeting {
                                    font-size: 15px;
                                    color: #1f2937;
                                    margin-bottom: 20px;
                                }
                                .message {
                                    color: #4b5563;
                                    font-size: 14px;
                                    margin-bottom: 15px;
                                }
                                .code-section {
                                    background-color: #f9fafb;
                                    border: 1px solid #e5e7eb;
                                    border-left: 4px solid #1B9A76;
                                    padding: 25px 30px;
                                    margin: 30px 0;
                                }
                                .code-label {
                                    font-size: 12px;
                                    text-transform: uppercase;
                                    letter-spacing: 1px;
                                    color: #6b7280;
                                    margin-bottom: 12px;
                                    font-weight: 600;
                                }
                                .code {
                                    font-size: 32px;
                                    font-weight: 700;
                                    color: #1B9A76;
                                    letter-spacing: 6px;
                                    font-family: 'Consolas', 'Courier New', monospace;
                                }
                                .validity {
                                    font-size: 13px;
                                    color: #6b7280;
                                    margin-top: 12px;
                                }
                                .notice {
                                    background-color: #fefce8;
                                    border: 1px solid #fde047;
                                    padding: 15px 20px;
                                    font-size: 13px;
                                    color: #854d0e;
                                    margin: 25px 0;
                                }
                                .signature {
                                    margin-top: 35px;
                                    padding-top: 25px;
                                    border-top: 1px solid #e5e7eb;
                                }
                                .signature p {
                                    margin: 3px 0;
                                    font-size: 13px;
                                    color: #6b7280;
                                }
                                .signature .team {
                                    color: #1f2937;
                                    font-weight: 600;
                                }
                                .footer {
                                    margin-top: 40px;
                                    padding-top: 25px;
                                    border-top: 1px solid #e5e7eb;
                                    font-size: 11px;
                                    color: #9ca3af;
                                }
                                .footer p {
                                    margin: 4px 0;
                                }
                                .footer a {
                                    color: #1B9A76;
                                    text-decoration: none;
                                }
                            </style>
                        </head>
                        <body>
                            <div class="container">
                                <div class="header">
                                    <div class="logo-text">Alumni UASZ</div>
                                    <div class="logo-sub">Université Assane Seck de Ziguinchor</div>
                                </div>

                                <div class="content">
                                    <p class="greeting">Bonjour <strong>%s</strong>,</p>

                                    <p class="message">Nous avons bien reçu votre demande d'inscription sur la plateforme Alumni UASZ.</p>

                                    <p class="message">Pour finaliser la création de votre compte, veuillez saisir le code de validation ci-dessous :</p>

                                    <div class="code-section">
                                        <div class="code-label">Code de validation</div>
                                        <div class="code">%s</div>
                                        <div class="validity">Valide pendant 15 minutes</div>
                                    </div>

                                    <div class="notice">
                                        Si vous n'êtes pas à l'origine de cette demande, vous pouvez ignorer ce message en toute sécurité.
                                    </div>

                                    <div class="signature">
                                        <p class="team">L'équipe Alumni UASZ</p>
                                        <p>Université Assane Seck de Ziguinchor</p>
                                    </div>
                                </div>

                                <div class="footer">
                                    <p>© 2024 Alumni UASZ. Tous droits réservés.</p>
                                    <p>Ce message a été envoyé automatiquement. Merci de ne pas y répondre directement.</p>
                                </div>
                            </div>
                        </body>
                        </html>
                                        """,
                nom, code);
    }

}