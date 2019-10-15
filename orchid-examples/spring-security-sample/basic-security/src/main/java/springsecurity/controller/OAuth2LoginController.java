package springsecurity.controller;

import org.springframework.stereotype.Controller;


@Controller
public class OAuth2LoginController {

//
//
//
//    @GetMapping("/")
//    public String index(Model model,
//                        @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
//                        @AuthenticationPrincipal OAuth2User oauth2User) {
//        model.addAttribute("userName", oauth2User.getName());
//        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
//        model.addAttribute("userAttributes", oauth2User.getAttributes());
//        return "index";
//    }
//
//
//    @GetMapping("/userinfo")
//    public String userinfo(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient) {
//        Map userAttributes = Collections.emptyMap();
//        String userInfoEndpointUri = authorizedClient.getClientRegistration()
//                .getProviderDetails().getUserInfoEndpoint().getUri();
//        if (!StringUtils.isEmpty(userInfoEndpointUri)) {	// userInfoEndpointUri is optional for OIDC Clients
//            userAttributes = WebClient.builder()
//                    .filter(oauth2Credentials(authorizedClient))
//                    .build()
//                    .get()
//                    .uri(userInfoEndpointUri)
//                    .retrieve()
//                    .bodyToMono(Map.class)
//                    .block();
//        }
//        model.addAttribute("userAttributes", userAttributes);
//        return "userinfo";
//    }
//
//    private ExchangeFilterFunction oauth2Credentials(OAuth2AuthorizedClient authorizedClient) {
//        return ExchangeFilterFunction.ofRequestProcessor(
//                clientRequest -> {
//                    ClientRequest authorizedRequest = ClientRequest.from(clientRequest)
//                            .header(HttpHeaders.AUTHORIZATION, "Bearer " + authorizedClient.getAccessToken().getTokenValue())
//                            .build();
//                    return Mono.just(authorizedRequest);
//                });
//    }
}
