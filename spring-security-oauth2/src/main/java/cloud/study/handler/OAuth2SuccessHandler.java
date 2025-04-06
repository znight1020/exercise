package cloud.study.handler;

import cloud.study.dto.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException {
    log.info("onAuthenticationSuccess");
    OAuth2User oAuth2User = (OAuth2User) auth.getPrincipal();
    UserInfo userInfo = UserInfo.builder()
        .email(oAuth2User.getAttribute("email"))
        .name(oAuth2User.getAttribute("name"))
        .build();

    String redirectUrl = "http://127.0.0.1:5500/front/src/login-success.html?email="
        + URLEncoder.encode(userInfo.email(), StandardCharsets.UTF_8)
        + "&name=" + URLEncoder.encode(userInfo.name(), StandardCharsets.UTF_8);

    res.sendRedirect(redirectUrl);
  }
}
