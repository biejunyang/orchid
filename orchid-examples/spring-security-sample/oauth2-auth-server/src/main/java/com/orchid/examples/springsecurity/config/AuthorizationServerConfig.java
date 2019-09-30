package com.orchid.examples.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {



    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 1、授权服务端点设置：
     *      AuthorizationEndpoint可以通过以下方式配置支持的授权类型AuthorizationServerEndpointsConfigurer。默认情况下，所有授权类型均受支持，
     *      authenticationManager：通过注入密码授权被打开AuthenticationManager。
     *      userDetailsService：如果您注入UserDetailsService或者全局配置（例如a GlobalAuthenticationManagerConfigurer），则刷新令牌授权将包含对用户详细信息的检查，以确保该帐户仍然活动
     *      authorizationCodeServices：定义AuthorizationCodeServices授权代码授权的授权代码服务（实例）。
     *      implicitGrantService：在批准期间管理状态。
     *      tokenGranter：（TokenGranter完全控制授予和忽略上述其他属性）

     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(this.authenticationManager);
    }



    /**
     * 2、授权服务端点安全约束
     *      获取令牌端点(/oauth/token)：
     *          不需要登录认证
     *          这个如果配置支持allowFormAuthenticationForClients的，且url中有client_id和client_secret的会走ClientCredentialsTokenEndpointFilter来保护
     *
     *
     *              如果没有支持allowFormAuthenticationForClients或者有支持
     *
     *              但是url中没有client_id和client_secret的，走basic认证保护
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
            .tokenKeyAccess("permitAll()")//获取令牌端点不要认证
            .checkTokenAccess("isAuthenticated()")//校验令牌端点需要授权过
                .allowFormAuthenticationForClients();
    }










    /**
     * 3、客户端认证配置：配置能够被认证的客户端信息，可以配置多个客户端
     *      clientId：（必须）客户端id。
     *      secret：（对于可信任的客户端是必须的）客户端的私密信息。
     *      scope：客户端的作用域。如果scope未定义或者为空（默认值），则客户端作用域不受限制。
     *      authorizedGrantTypes：授权给客户端使用的权限类型。默认值为空。
     *      authorities：授权给客户端的权限（Spring普通的安全权限）。
     *
     *配置方式：
     *      1.1、内存中设置客户端信息inMemory()
     *      1.2、从数据源中获取客户端信息，默认的表结构中
     *      1.3、自定义通过clientId获取客户端信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        1、内存中设置客户端信息inMemory()，注意授权码授权时，必须设置好重定向地址
        clients
            .inMemory().withClient("client").secret("{noop}client")
                .authorizedGrantTypes("client_credentials", "authorization_code", "refresh_token", "password")
                .scopes("read","write")
                .redirectUris("http://baidu.com").accessTokenValiditySeconds(600_000_000);

        //2、从jdbc数据源中获取客户端信息，默认的表结构中
//        clients.jdbc(dataSource);
//        clients.withClientDetails(new JdbcClientDetailsService(dataSource));


//        3、自定义通过clientId获取客户端信息
//        clients.withClientDetails(new ClientDetailsService() {
//            @Override
//            public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
//
//                return null;
//            }
//        });
    }

}
